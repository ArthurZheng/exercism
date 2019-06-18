//package Isogram
//
//fun isIsogram(inputString: String): Boolean {
//    val pattern = "[a-zA-Z]".toRegex()
//    val formatInputToArrayList = pattern.findAll(inputString).map{it.value}.map{it.toLowerCase()}.toList()
//    val sizeOfOriginalInput = formatInputToArrayList.count()
//    val sizeOfDistinctOriginalInput = formatInputToArrayList.distinct().count()
//    return if (sizeOfOriginalInput == sizeOfDistinctOriginalInput) true else false
//}


//object Isogram {
//    fun isIsogram(inputString: String): Boolean {
//        return inputString.toLowerCase().filter{ it.isLetter() }.let { it.toSet().size == it.length}
//    }
//}

//object Isogram {
//    fun isIsogram(inputString: String): Boolean {
//        val onlyLettersInInputString = inputString.filter{ it.isLetter() }.toLowerCase()
//        return onlyLettersInInputString.toSet().size == onlyLettersInInputString.length
//    }
//}
//


//package Isogram
//fun isIsogram(input: String) = ('a'..'z').fold(true) {acc, cur -> input.filter{it.toLowerCase() == cur}.length <= 1 && acc}

//
//package Isogram
//fun isIsogram(s: String): Boolean {
//    return s.toLowerCase()
//                    .groupBy { it }
//                    .filterKeys { it !in listOf('-', ' ') }
//                    .values
//                    .map { it.count() }
//                    .all { it <= 1 }
//}
//


//package Isogram
//fun isIsogram(inputString: String): Boolean {
//    return inputString.toLowerCase().filter{it.isLetter()}.groupBy { it }.all { it.value.size == 1}
//}

package Isogram
//fun isIsogram(inputString:String) = !inputString.toLowerCase().filter{ it.isLetter() }.groupBy{ it }.any { it.value.size > 1}
fun isIsogram(inputString: String) = inputString.toLowerCase().filter{ it.isLetter() }.groupBy{ it }.all { it.value.size == 1}