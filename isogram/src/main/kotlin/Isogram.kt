package Isogram

fun isIsogram(inputString: String): Boolean {
    val pattern = "[a-zA-Z]".toRegex()
    val formatInputToArrayList = pattern.findAll(inputString).map{it.value}.map{it.toLowerCase()}.toList()
    val sizeOfOriginalInput = formatInputToArrayList.count()
    val sizeOfDistinctOriginalInput = formatInputToArrayList.distinct().count()
    return if (sizeOfOriginalInput == sizeOfDistinctOriginalInput) true else false
}