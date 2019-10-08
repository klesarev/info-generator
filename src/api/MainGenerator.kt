package api

import com.google.gson.Gson
import com.google.gson.JsonParser
import entity.GeoObject
import utils.NetDataProvider
import java.lang.Exception
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random

class MainGenerator() {

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

    fun genName(): String {

        // realization //

        return "Mr. Nobody";
    }


    fun genAdress(secretkey: String, limit: Int, coords: HashMap<String,String>):ArrayList<GeoObject> {
        val list: ArrayList<GeoObject> = ArrayList();
        val req = NetDataProvider()
            .getData("https://geocode-maps.yandex.ru/1.x/" +
                    "?apikey=${secretkey}" +
                    "&geocode=${coords.get("lat")},${coords.get("long")}" +
                    "&kind=house" +
                    "&results=${limit}" +
                    "&format=json"
            );

        try {
            for (elem in 0..limit-1) {
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
        return list
    }
}
