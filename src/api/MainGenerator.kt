package api

import com.google.gson.Gson
import com.google.gson.JsonParser
import entity.Codes
import entity.GeoObject
import entity.Person
import utils.DataProvider
import utils.FileDataProvider
import utils.NetDataProvider
import java.lang.Exception
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random

class MainGenerator() {

    fun generatePerson(limit: Int, secret: String): List<Person> {
        var personsList: ArrayList<Person> = ArrayList<Person>();
        var hashMap:HashMap<String,String> = HashMap<String,String>();
        hashMap.put("lat","37.525879")
        hashMap.put("long","55.726251")

        /* main method generator */
        /*
        * genPhone()
        * genName()
        * genEmail()
        * */

//        for (person in 0..limit-1) {
//            personsList.add(
//                Person(
//                    genName(),
//                    genPhone(Codes.MOBILE.generate()),
//                    genAdress(secret, hashMap).text
//                )
//            )
//        }
        return personsList
    }

    fun genPhone(code: Int):String {
        var phone:String = "+7(${code})";
        for (n in 1..7 ) {
            phone += "${Random.nextInt(0,9)}"
        }
        return StringBuilder(phone)
                .insert(10,"-")
                .insert(13,"-")
                .toString();
    }

    fun genName(id: Int): String {
//        val name: DataProvider<String> = FileDataProvider();
//        val mr = name.getDataByid("names.txt", id)
        return "mr";
    }


    fun genAdress(secretkey: String, coords: HashMap<String,String>): GeoObject {
        val list: ArrayList<GeoObject> = ArrayList();
        val netProvider: DataProvider<String> = NetDataProvider();
        val req = netProvider
            .getData("https://geocode-maps.yandex.ru/1.x/" +
                    "?apikey=${secretkey}" +
                    "&geocode=${coords.get("lat")},${coords.get("long")}" +
                    "&kind=house" +
                    "&results=100" +
                    "&format=json"
            );

        try {
            for (elem in 0..9) {
                val jelement = JsonParser().parse(req)
                val jarray = jelement.getAsJsonObject()
                    .getAsJsonObject("response")
                    .getAsJsonObject("GeoObjectCollection")
                    .getAsJsonArray("featureMember")
                    .get(elem)
                    .asJsonObject
                    .getAsJsonObject("GeoObject")
                    .getAsJsonObject("metaDataProperty")
                    .getAsJsonObject("GeocoderMetaData")

                val adress = Gson().fromJson(jarray, GeoObject::class.java)
                list.add(adress);
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return list.random()
    }
}
