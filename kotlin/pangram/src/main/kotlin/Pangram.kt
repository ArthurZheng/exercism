//object Pangram {
//    fun isPangram(sentence: String) = ('a'..'z').all { sentence.contains(it, ignoreCase = true)}
//}


//object Pangram {
////    fun isPangram(sentence: String): Boolean {
////        return ('a'..'z').all { sentence.contains(it, ignoreCase = true)}
////    }
////}


//class Pangram {
//    companion object {
//        fun isPangram(sentence: String): Boolean {
//            val alphabet = 'a'..'z'
//            return alphabet.all { sentence.contains(it, ignoreCase = true)}
//        }
//    }
//}

//const val ASCII_SIZE: Int = 26
//class Pangram {
//    companion object {
//        fun isPangram(input: String): Boolean {
//            return  input.filter { it.isLetter() }.toLowerCase().toSet().size == ASCII_SIZE
//        }
//    }
//}

const val ASCII_SIZE: Int = 26
class Pangram {
    companion object {
        fun isPangram(sentence: String): Boolean {
//            return sentence.toLowerCase().filter{ it in 'a'..'z'}.toSet().size == ASCII_SIZE
//            return sentence.toLowerCase().filter{ it in 'a'..'z'}.toHashSet().size == ASCII_SIZE
//            return sentence.toLowerCase().filter{ it in 'a'..'z'}.groupBy{ it }.size == ASCII_SIZE
            return sentence.toLowerCase().chars().filter(Character::isAlphabetic).distinct().count() == 26L
        }
    }
}


























