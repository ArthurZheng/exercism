//package Acronym
//
//fun generate(phrase:String): String {
//    val regex = """ - |-""".toRegex()
//    return regex.replace(phrase, " ")
//            .split(" ")
//            .map{ it -> it.get(0) }
//            .joinToString("")
//            .toUpperCase()
//}

// this doesn't quite work
//object Acronym {
//    fun generate(phrase: String) = phrase.split(" ", "-")
//            .map { it.first().toUpperCase() }
//            .joinToString("")
//}
//


//object Acronym {
//    fun generate(phrase: String) = Regex("[A-Z]+[a-z]*|[a-z]+").findAll(phrase).map { it.value.first().toUpperCase() }.joinToString("")
//}


//object Acronym {
//    fun generate(phrase: String): String {
//        return phrase.split("([ -])".toRegex()).map { it.first().toUpperCase()}.joinToString(separator = "")
//    }
//
//}


//object Acronym {
//    fun generate(phrase: String) : String =
//        Regex("\\b\\w")
//                .findAll(phrase)
//                .joinToString("") {it.value.toUpperCase()}
//}
//


//object Acronym {
//    fun generate(phrase: String): String {
//        return phrase.split("[^a-zA-Z]+".toRegex())
//                .joinToString("") {
//                    it.first().toUpperCase().toString()
//                }
//    }
//}


//object Acronym {
//
//  fun generate(phrase: String): String =
//    phrase
//      .split(" ", "-")
//      .fold("", { acc, s -> acc + s.take(1).capitalize() })
//}

//object Acronym {
//  fun generate(phrase: String): String {
//    return  phrase.split(" ", "-").filter{ it -> it != ""}.fold(""){ acc, s -> acc + s.take(1).capitalize() }
//  }
//}

object Acronym {
  fun generate(phrase: String): String {
    return  phrase.split(" ", "-").fold(""){ acc, s -> acc + s.take(1).capitalize() }
  }
}






















