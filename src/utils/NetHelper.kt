package utils

import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class NetHelper () {
    val response = StringBuilder();

    fun sendRequest(link: String): String {
        val url = URL(link);

//        if (options != null) {
//            val sb = StringBuilder();
//            for ((key, value) in options.entries) {
//                sb.append("${key}=${value}&")
//            }
//            url = URL(link + "/?" + sb.delete(sb.length-1,sb.length));
//        } else {
//            url = URL(link)
//        }

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET";
            if (responseCode == 200) {
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        response.append(line).append(System.lineSeparator());
                    }
                }
            } else println("some erros in request");
        }
        return response.toString();
    }
}