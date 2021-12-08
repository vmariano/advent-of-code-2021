package day_2

import FileHelper

fun main() {
    //--- Part One ---
    val instructions = FileHelper.loadFileByLines("day_2/input.txt")
    var horizontalPosition = 0
    var deephtPosition = 0


    instructions.forEach {
        val (instruction, value) = it.split(" ")
        when(instruction) {
            "forward" -> {  horizontalPosition += value.toInt() }
            "up" -> {  deephtPosition -= value.toInt() }
            "down" -> {  deephtPosition += value.toInt() }
        }

    }
    println( deephtPosition * horizontalPosition)


    //--- Part Two ---
     horizontalPosition = 0
     deephtPosition = 0
    var aim = 0

    instructions.forEach {
        val (instruction, value) = it.split(" ")
        when(instruction) {
            "forward" -> {
                horizontalPosition += value.toInt()
                deephtPosition += value.toInt() * aim
            }
            "up" -> {
                aim -= value.toInt()
            }
            "down" -> {
                aim += value.toInt()
            }
        }

    }
    println( deephtPosition * horizontalPosition)

}
