package day1

fun main() {
    val inputData = importData("src/main/kotlin/day1/input.txt")
    val pairs = findPairsAddingUpTo2020(inputData)
    pairs.forEach { println(it.first * it.second) }
}

fun findPairsAddingUpTo2020(input: List<Int>): List<Pair<Int, Int>> = findPairsAddingUpTo(2020, input)
