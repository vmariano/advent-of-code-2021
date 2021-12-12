package day_3

import FileHelper

fun main() {
    //--- Part One ---
    println(partOne())

    //--- Part Two ---


}

fun partOne(): Int {
    return gammaRate().toInt(2) * epsilonRate().toInt(2)
}

fun epsilonRate(): String {
    val readsMatrix = transposeInput()
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
    val readsMatrix = transposeInput()
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

private fun transposeInput(): Array<Array<String>> {
    val reads = FileHelper.loadInputFile("day_3/input.txt")
    val numberSize = reads.first().length
    val readsMatrix = Array(numberSize) { Array(reads.size) { "" } }
    reads.forEachIndexed { i, number ->
        val slicesItem = number.split("").filterNot { it.equals("") }
        slicesItem.forEachIndexed { j, item ->
            readsMatrix[j][i] = item
        }
    }
    return readsMatrix
}
