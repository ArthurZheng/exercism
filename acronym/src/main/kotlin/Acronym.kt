package Acronym

fun generate(phrase:String): String {
    val regex = """ - |-""".toRegex()
    return regex.replace(phrase, " ")
            .split(" ")
            .filterNotNull()
            .map{ it -> it.get(0) }
            .joinToString("")
            .toUpperCase()
}