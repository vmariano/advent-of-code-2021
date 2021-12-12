import java.io.File

class FileHelper {
    companion object {
        fun loadInputAsInt(path:String): List<Int> = loadInputFile(path).map { it.toInt() }

        fun loadInputFile(path:String): List<String> {
            val file = this.javaClass.classLoader.getResource(path)?.file
            val inputStream = File(file).inputStream()
            val inputString = inputStream.bufferedReader().use { it.readText() }
            return inputString.split("\n")
        }
    }

}