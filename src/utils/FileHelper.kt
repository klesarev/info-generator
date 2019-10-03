package utils

import java.io.BufferedReader
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class FileHelper {

    fun writeFile(filePath: String, fileContent: String) {
        try {
            Files.write(Paths.get(filePath), fileContent.toByteArray(), StandardOpenOption.APPEND, StandardOpenOption.CREATE)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

    }

    fun readFile(filePath: String): String {
        var result: String = ""
        try {
            val bufferedReader: BufferedReader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
            result = bufferedReader.use { it.readText() };
        } catch (ex: IOException) {
            ex.printStackTrace();
        }
        return result
    }

}
