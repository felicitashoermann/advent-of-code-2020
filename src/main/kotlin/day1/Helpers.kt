package day1

import java.io.File

fun importData(filepath: String): List<Int> = File(filepath).readLines().map { it.toInt() }

fun findPairsAddingUpTo(targetValue: Int, input: List<Int>): List<Pair<Int, Int>> {
    val sortedInput = input.sorted()
    val result = arrayListOf<Pair<Int, Int>>()

    sortedInput.forEach {
        val additionPartner = targetValue - it
        val isAlreadyRecorded = result.contains(Pair(additionPartner, it))
        if (!isAlreadyRecorded) {
            if (sortedInput.binarySearch(additionPartner) >= 0) {
                result.add(Pair(it, additionPartner))
            }
        }
    }

    return result
}

fun <A>Triple<A, A, A>.equalsIgnoringOrder(triple: Triple<A, A, A>) =
    this.toList().toSet().equals(triple.toList().toSet())
