package day1

import java.io.File

fun main() {
    val inputData = importData("src/main/kotlin/day1/input.txt")
    val pairs = findPairsAddingUpTo2020(inputData)
    pairs.forEach { println(it.first * it.second) }
}

fun importData(filepath: String): List<Int> = File(filepath).readLines().map { it.toInt() }

fun findPairsAddingUpTo2020(input: List<Int>): List<Pair<Int, Int>> {
    val sortedInput = input.sorted()
    val result = arrayListOf<Pair<Int, Int>>()

    sortedInput.map {
        val additionPartner = 2020 - it
        if (!result.contains(Pair(additionPartner, it))) {
            if (sortedInput.binarySearch(additionPartner) >= 0) {
                result.add(Pair(it, additionPartner))
            }
        }
    }

    return result
}
