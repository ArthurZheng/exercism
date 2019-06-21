class Anagram(val detector: String) {
	fun match(inputList: List<String>): Set<String> {
		val zippedInputArrays = inputList.filter{it.toLowerCase() != detector.toLowerCase() }.map { it.toLowerCase().toCharArray().sorted().joinToString("") }.zip(inputList)
        val resultList: MutableList<String> = ArrayList()
		val sortedDetectorString = detector.toLowerCase().toCharArray().sorted().joinToString("")
        zippedInputArrays.forEach{ (a, b) ->

           	if (a.length <= sortedDetectorString.length && a.contains(sortedDetectorString)) resultList += b
        }

		return resultList.toSet()
	}



}