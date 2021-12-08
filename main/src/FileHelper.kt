import java.io.File

class FileHelper {
    companion object {
        fun loadInput(path:String): List<Int> = loadFileByLines(path).map { it.toInt() }

        fun loadFileByLines(path:String): List<String> {
            val file = this.javaClass.classLoader.getResource(path)?.file
            val inputStream = File(file).inputStream()
            val inputString = inputStream.bufferedReader().use { it.readText() }
            return inputString.split("\n")
        }
    }

}