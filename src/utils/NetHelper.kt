package utils

import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class NetHelper:DataProvider<String> {
    override fun getData(link: String): String {
        val url = URL(link);
        val response = StringBuilder();

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