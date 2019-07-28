//class Anagram(val detector: String) {
//	fun match(inputList: List<String>): Set<String> {
//		val zippedInputArrays = inputList.filter{it.toLowerCase() != detector.toLowerCase() }.map { it.toLowerCase().toCharArray().sorted().joinToString("") }.zip(inputList)
//        val resultList: MutableList<String> = ArrayList()
//		val sortedDetectorString = detector.toLowerCase().toCharArray().sorted().joinToString("")
//        zippedInputArrays.forEach{ (a, b) ->
//           	if (a.length <= sortedDetectorString.length && a.contains(sortedDetectorString)) resultList += b
//        }
//		return resultList.toSet()
//	}
//}

//data class Anagram(val text: String) {
//    private val lowerText = text.toLowerCase()
//    // it to it.toLowerCase() creates a pair for the map
//    fun match(candidates: Collection<String>) = candidates
//            .map { it to it.toLowerCase() }
//            .filter { it.second != lowerText && it.second.toList().sorted() == lowerText.toList().sorted() }
//            .map { it.first }.toSet()
//}

//class Anagram(val word: String = "") {
//    fun match(candidate: List<String>): Set<String> = candidate.filter{it.toUpperCase() != word}.filter{ it.toLowerCase().toList().sorted() == word.toLowerCase().toList().sorted()}.toSet()
//}

//class Anagram(val word: String = ""){
//    fun match(candidate: List<String>): Set<String> {
//        return candidate.filter{ it.toUpperCase() != word}.filter{ it.toLowerCase().toList().sorted() == word.toLowerCase().toList().sorted()}.toSet()
//    }
//}


//class Anagram(val word: String = "") {
//    fun match(candidate: List<String>): Set<String> {
//        return candidate.filter{ it.toUpperCase() != word}.filter{matchedList(it, word)}.toSet()
//    }
//
//    private fun matchedList(inputString: String, detector: String): Boolean {
//        return inputString.toLowerCase().toList().sorted() == detector.toLowerCase().toList().sorted()
//    }
//}

//
//class Anagram (val word: String) {
//    fun match(candidate: List<String>): Set<String> {
//        return candidate.filter{ it.toUpperCase() != word}.filter{ it.sorted() == word.sorted()}.toSet()
//    }
//
//    private fun String.sorted() = this.toLowerCase().toList().sorted()
//}


//class Anagram(val word: String) {
//    fun match(candidate: List<String>): Set<String> {
//        return candidate.filter{ it.toUpperCase() != word}.filter{ matched(it) == matched(word)}.toSet()
//    }
//
//    private fun matched(inputList: String) = inputList.toLowerCase().toList().sorted()
//}


class Anagram(val word: String) {
    fun match(candidate: List<String>): Set<String> = candidate.filter{ isAnagram(it, word)}.toSet()

    private fun isAnagram(inputString: String, word: String): Boolean {
        return if (inputString.toUpperCase() != word && inputString.toLowerCase().toList().sorted() == word.toLowerCase().toList().sorted()) true else false
    }

}



















