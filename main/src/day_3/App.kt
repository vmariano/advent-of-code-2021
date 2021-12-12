package day_3

import FileHelper

fun main() {
    //--- Part One ---
    println(partOne())

    //--- Part Two ---


}

fun partOne(): Any? {
    return gammaRate().toInt(2) * epsilonRate().toInt(2)
}

fun epsilonRate(): String {
    var readsMatrix = transposeInput()
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
    var readsMatrix = transposeInput()
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

private fun transposeInput(): kotlin.Array<kotlin.Array<String>> {
    val reads = FileHelper.loadInputFile("day_3/input.txt")
    var readsMatrix = Array(12) { Array(reads.size) { "" } }
    reads.forEachIndexed { i, it ->
        val slicesItem = it.split("").filterNot { it.equals("") }
        slicesItem.forEachIndexed { j, item ->
            readsMatrix[j][i] = item
        }
    }
    return readsMatrix
}
