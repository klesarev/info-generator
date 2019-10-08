package utils

import java.io.BufferedReader
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class FileHelper: WriteableDataProvider<String, String> {

    override fun getData(file: String): String {
        var result: String = ""
        try {
            val bufferedReader: BufferedReader = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8);
            result = bufferedReader.use { it.readText() };
        } catch (ex: IOException) {
            ex.printStackTrace();
        }
        return result
    }

    override fun writeData(file: String, content: String) {
        try {
            Files.write(Paths.get(file), content.toByteArray(), StandardOpenOption.APPEND, StandardOpenOption.CREATE)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

}
