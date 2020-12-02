package day2

fun main() {
    val inputData = importData("src/main/kotlin/day2/input.txt")
    val validPasswords = inputData.filter { isPasswordValidAccordingToNewPolicy(it) }
    println(validPasswords.size)
}

fun isPasswordValidAccordingToNewPolicy(input: String): Boolean {
    val policy = input.substringBefore(":")
    val password = input.substringAfterLast(" ")

    val firstPosition = policy.substringBefore("-").toInt()
    val secondPosition = policy.substringAfter("-").substringBefore(" ").toInt()
    val policyChar = policy.get(policy.length - 1)

    if (firstPosition <= password.length && secondPosition <= password.length) {
        val isFirstPositionPolicyChar = password.get(firstPosition - 1) == policyChar
        val isSecondPositionPolicyChar = password.get(secondPosition - 1) == policyChar

        return isFirstPositionPolicyChar && !isSecondPositionPolicyChar
                || !isFirstPositionPolicyChar && isSecondPositionPolicyChar
    } else {
        println("Password is too short")
        return false
    }
}
