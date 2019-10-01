package api

import com.google.gson.Gson
import com.google.gson.JsonParser
import entity.GeoObjectItem
import utils.FileHelper
import utils.NetHelper
import java.lang.Exception
import java.util.*
import java.util.logging.SimpleFormatter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random

class MainGenerator() {

    fun genPhone(code: String):String {
        var phone:String = "+7(${code})";
        for (n in 1..7 ) {
            phone += "${Random.nextInt(0,9)}"
        }
        return phone;
    }

    fun genName(): String {

        // realization //

        return "Mr. Nobody";
    }

    fun genAdress(secretkey: String, limit: Int, coords: HashMap<String,String>):ArrayList<GeoObjectItem> {
        val list: ArrayList<GeoObjectItem> = ArrayList();
        val req = NetHelper()
            .sendRequest("https://geocode-maps.yandex.ru/1.x/" +
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

                val adress = Gson().fromJson(jarray, GeoObjectItem::class.java)
                list.add(adress);
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return list
    }
}
