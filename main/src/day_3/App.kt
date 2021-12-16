package day_3

class MatrixHelpers {
    companion object {
        fun reduceMatrix(readsMatrix: Array<Array<String>>, filterIndexes: MutableList<Int>): Array<Array<String>> {
            val newMatrix = Array(readsMatrix.size) { Array(filterIndexes.size) { "" } }
            val columnSize = readsMatrix.size
            for (j in 0 until columnSize) {
                filterIndexes.forEachIndexed { i, column ->
                    newMatrix[j][i] = readsMatrix[j][column]
                }
            }
            return newMatrix
        }

        fun transformMatrixToNumber(readsMatrix: Array<Array<String>>): Int = readsMatrix.reduce { a, c -> a + c[0] }.reduce { a, c -> a + c }.toInt(2)

        fun transposeInput(input: List<String>): Array<Array<String>> {
            val numberSize = input.first().length
            val readsMatrix = Array(numberSize) { Array(input.size) { "" } }
            input.forEachIndexed { i, number ->
                val slicesItem = number.split("").filterNot { it.equals("") }
                slicesItem.forEachIndexed { j, item ->
                    readsMatrix[j][i] = item
                }
            }
            return readsMatrix
        }

        fun filterIndexes(row: Array<String>, filterCriteria: String): MutableList<Int> {
            val filterIndexes = mutableListOf<Int>()
            row.forEachIndexed() { i, number ->
                if (number == filterCriteria) {
                    filterIndexes.add(i)
                }
            }
            return filterIndexes
        }
    }
}

fun main() {
    //--- Part One ---
    println(partOne())

    //--- Part Two ---
    println(partTwo())
}

fun partTwo(): Int {
    return  oxygenGenerationRating() * CO2ScrubberRating()
}

fun CO2ScrubberRating(): Int {
    val readsMatrix = MatrixHelpers.transposeInput(FileHelper.loadInputFile("day_3/input.txt"))
    return filterC02Rating(readsMatrix, 0)}

fun filterC02Rating(readsMatrix: Array<Array<String>>, rowIndex: Int): Int {
    if (readsMatrix[0].size == 1) {
        return MatrixHelpers.transformMatrixToNumber(readsMatrix)
    }
    val row = readsMatrix[rowIndex]
    val (match, rest) = row.partition { it == ("0") }
    val filterCriteria = if (match.size <= rest.size)  "0"  else "1"
    val filterIndexes = MatrixHelpers.filterIndexes(row, filterCriteria)
    val newMatrix = MatrixHelpers.reduceMatrix(readsMatrix, filterIndexes)
    return filterC02Rating(newMatrix, rowIndex+1)
}

fun oxygenGenerationRating(): Int {
    val readsMatrix = MatrixHelpers.transposeInput(FileHelper.loadInputFile("day_3/input.txt"))
    return filterOxygenConditions(readsMatrix, 0)
}

fun filterOxygenConditions(readsMatrix: Array<Array<String>>, rowIndex: Int): Int {
    if (readsMatrix[0].size == 1) {
       return MatrixHelpers.transformMatrixToNumber(readsMatrix)
    }
    val row = readsMatrix[rowIndex]
    val (match, rest) = row.partition { it == ("1") }
    val filterCriteria = if (match.size >= rest.size)  "1"  else "0"
    val filterIndexes = MatrixHelpers.filterIndexes(row, filterCriteria)
    val newMatrix = MatrixHelpers.reduceMatrix(readsMatrix, filterIndexes)
    return filterOxygenConditions(newMatrix, rowIndex+1)
}

fun partOne(): Int {
    return gammaRate().toInt(2) * epsilonRate().toInt(2)
}

fun epsilonRate(): String {
    val readsMatrix = MatrixHelpers.transposeInput(   FileHelper.loadInputFile("day_3/input.txt"))
    var result = ""
    readsMatrix.forEach {
        result += if (it.filter { it.equals("1") }.size > it.filter { it.equals("0") }.size) {
            "0"
        } else {
            "1"
        }
    }
    return result
}

fun gammaRate(): String {
    val readsMatrix = MatrixHelpers.transposeInput(   FileHelper.loadInputFile("day_3/input.txt"))
    var result = ""
    readsMatrix.forEach {
       result += if (it.filter { it.equals("1") }.size > it.filter { it.equals("0") }.size) {
            "1"
        } else {
            "0"
        }
    }
    return result
}
