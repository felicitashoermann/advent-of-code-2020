package day2

import java.io.File

fun importData(filepath: String): List<String> = File(filepath).readLines()
