//fun reverse( inputString: String): String {
////    return inputString.toCharArray().reversedArray().joinToString("")
//    return inputString.toCharArray().reversed().joinToString("")
//}

//fun reverse( inputString: String ) = inputString.reversed()


//fun reverse(str:String): String { return str.split(" ").reduce{acc, x -> x + " " + acc}}

//fun reverse(str:String): String { return str.fold(""){ acc, x -> x + acc } }

fun reverse(str: String) = str.reduce{ acc, x -> x + acc}
fun reverse(str: String) = str.fold(""){ acc, x -> x + acc}
fun reverse(str: String) = str.reversed()