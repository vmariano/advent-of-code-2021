package day_1

import FileHelper

fun main() {
    var result = -1
    FileHelper.loadInput("day_1/input.txt").fold(0) { a, c ->
        if (a < c) {
            result += 1
        }
        c
    }
    print(result)
}
