package Raindrops

//fun convert(input: Int): String {
//    val raindrops = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong").filter{ input.rem( it.key) == 0}.values.joinToString("")
//    return if(raindrops.isEmpty()) input.toString() else raindrops
//}

fun convert(num: Int): String {
    val raindrops = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong").filter { num.rem(it.key) == 0 }.values.joinToString("")
    return if(raindrops.isEmpty()) num.toString() else raindrops
}