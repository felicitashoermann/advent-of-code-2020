package day2


fun main() {
    val inputData = importData("src/main/kotlin/day2/input.txt")
    val validPasswords = inputData.filter { isPasswordValid(it) }
    println(validPasswords.size)
}

fun isPasswordValid(input: String): Boolean {
    val policy = input.substringBefore(":")
    val password = input.substringAfterLast(" ")

    val lowerPolicyBound = policy.substringBefore("-").toInt()
    val upperPolicyBound = policy.substringAfter("-").substringBefore(" ").toInt()
    val policyChar = policy.get(policy.length - 1)

    val policyCharCount = password.filter { it == policyChar }.length
    return lowerPolicyBound <= policyCharCount && policyCharCount <= upperPolicyBound
}
