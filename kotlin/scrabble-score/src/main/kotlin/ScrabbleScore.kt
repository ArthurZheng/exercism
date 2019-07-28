object ScrabbleScore {
    fun scoreWord(inputString: String): Int {
        return inputString.toUpperCase().sumBy{ letterToValue(it) }
    }

    private fun letterToValue(input: Char): Int {
        return when(input){
            in "AEIOULNRST" -> 1
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            in "JX" -> 8
            in "QZ" -> 10
            in "K" -> 5
            else -> 0
        }
    }

}


fun letterToValue(input: Char): Int {
	when(input){
		input in listOf(A, E, I, O, U, L, N, R, S, T ) -> 1
		input in listOf(D, G) -> 2
		input in listOf(B, C, M, P) -> 3
		input in listOf(F, H, V, W, Y) -> 4
		input in listOf(K) -> 5
		input in listOf(J, X) -> 8
		input in listOf(Q, Z) -> 10
		else -> 0
	}
}


object ScrabbleScore {
    fun scoreWord(input: String) =
        input.toUpperCase().sumBy { when (it) {
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            'K' -> 5
            in "JX" -> 8
            in "QZ" -> 10
            else -> 1
        } }
}


//object ScrabbleScore {
//    fun scoreWord(inputString: String): Int {
//        return inputString.toUpperCase().toList().sumBy{ letterToValue(it) }
//    }
//
//    private fun letterToValue(input: Char): Int {
//        return when(input){
//            in listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' ) -> 1
//            in listOf('D', 'G') -> 2
//            in listOf('B', 'C', 'M', 'P') -> 3
//            in listOf('F', 'H', 'V', 'W', 'Y') -> 4
//            in listOf('K') -> 5
//            in listOf('J', 'X') -> 8
//            in listOf('Q', 'Z') -> 10
//            else -> 0
//        }
//    }
//
//}
//


object ScrabbleScore {
    fun scoreWord(inputString: String): Int {
        return inputString.toUpperCase().sumBy{ letterToValue(it) }
    }

    private fun letterToValue(input: Char): Int {
        return when(input){
            in "AEIOULNRST" -> 1
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            in "JX" -> 8
            in "QZ" -> 10
            in "K" -> 5
            else -> 0
        }
    }

}


//object ScrabbleScore {
//	fun scoreWord(word: String): Int {
//		return word.toUpperCase().sumBy{ scoreLetter(it) }
//	}
//
//	private fun scoreLetter(letter: Char): Int {
//		return when (letter) {
//			in "AEIOULNRST" -> 1
//			in "DG" -> 2
//			in "BCMP" -> 3
//			in "FHVWY" -> 4
//			in "K" -> 5
//			in "JX" -> 8
//			in "QZ" -> 10
//			else -> 0
//		}
//	}
//}



//
//        when (it) {
//            'Q', 'Z' -> 10
//            'J', 'X' -> 8
//            'K' -> 5
//            'F', 'H', 'V', 'W', 'Y' -> 4
//            'B', 'C', 'M', 'P' -> 3
//            'D', 'G' -> 2
//            else -> 1
//        }



//object ScrabbleScore {
//    fun scoreWord(input: String) =
//        input.toUpperCase().sumBy { when (it) {
//            in "DG" -> 2
//            in "BCMP" -> 3
//            in "FHVWY" -> 4
//            'K' -> 5
//            in "JX" -> 8
//            in "QZ" -> 10
//            else -> 1
//        } }
//}


//object ScrabbleScore {
//	fun scoreWord(word: String): Int {
//		return word.toUpperCase().sumBy{ scoreLetter(it) }
//	}
//
//	fun scoreLetter(letter: Char) = when(letter) {
//		in "AEIOULNRST" -> 1
//		in "DG" -> 2
//		in "BCMP" -> 3
//		in "FHVWY" -> 4
//		in "K" -> 5
//		in "JX" -> 8
//		in "QZ" -> 10
//		else -> 0
//	}
//}

