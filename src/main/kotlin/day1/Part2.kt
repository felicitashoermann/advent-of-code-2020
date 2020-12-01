package day1

fun main() {
    val inputData = importData("src/main/kotlin/day1/input.txt")
    val triples = findTriplesAddingUpTo2020(inputData)
    triples.forEach { println(it.first * it.second * it.third) }
}

fun findTriplesAddingUpTo2020(input: List<Int>): List<Triple<Int, Int, Int>> {
    val sortedInput = input.sorted();
    val result = arrayListOf<Triple<Int, Int, Int>>()

    sortedInput.forEach {
        val additionPartner = 2020 - it
        val resultingPairs = findPairsAddingUpTo(additionPartner, sortedInput)
        val resultingTriples = resultingPairs.map { pair -> Triple(it, pair.first, pair.second) }

        resultingTriples.forEach {
            if (!result.any { it.equalsIgnoringOrder(it)})
                result.add(it)
        }
    }

    return result
}
