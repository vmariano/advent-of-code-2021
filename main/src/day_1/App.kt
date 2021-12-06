package day_1

import FileHelper

fun main() {
    //--- Part One ---
    val measurementList = FileHelper.loadInput("day_1/input.txt")
    var result = -1
    measurementList.fold(0) { a, c ->
        if (a < c) {
            result += 1
        }
        c
    }
    println(result)

    //--- Part Two ---
    var result2 = -1
    var previous = 0
    measurementList.forEachIndexed { index, item ->
        val subSet = measurementList.subList(index, measurementList.lastIndex+1).take(3)
        val calculation = subSet.fold(0) { a, c -> a+c }
        if (subSet.size == 3) {
            if (previous < calculation) {
                result2 += 1
            }
            previous = calculation
        }

    }
    println(result2)
}
