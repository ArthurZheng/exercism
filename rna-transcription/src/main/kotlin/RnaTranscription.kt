////fun transcribeToRna(input:String): String{
////    fun transcribe(dna: Char) = when(dna) {
////        'G' -> 'C'
////        'C' -> 'G'
////        'T' -> 'A'
////        'A' -> 'U'
////        else -> throw IllegalArgumentException("Unknown component:$dna")
////    }
////    return input.map(::transcribe).joinToString("")
////}
//
//
////=====================================================
////
////val dnaToRna = mapOf('C' to 'G', 'G' to 'C', 'T' to 'A', 'A' to 'U')
////fun transcribeToRna(input: String): String = input.map { dnaToRna[it] }.joinToString("")
////
//
////=====================================================
//
////fun transcribeToRna(dna: String): String = dna.map {
////    when (it) {
////        'G' -> "C"
////        'C' -> "G"
////        'T' -> "A"
////        'A' -> "U"
////        else -> ""
////    }
////}.joinToString("")
////
//
//
////=====================================================
//fun transcribeToRna(input: String):String{
//    return input.fold(""){ rna, dna -> rna + transcribe(dna)}
//}
//
//fun transcribe(nucleotide: Char): Char {
//   return when(nucleotide){
//        'G' -> 'C'
//        'C' -> 'G'
//        'T' -> 'A'
//        else -> 'U'
//    }
//}
//
////=====================================================
//
//val dnaToRnaMap = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')
//
//fun transcribeToRna(dna: String) =
//    dna.toCharArray().map { dnaToRnaMap[it] ?: it }.joinToString("")
//
////=====================================================
//
//
//val dnaToRnaMap = mapOf(
//        Pair('G', 'C'),
//        Pair('C', 'G'),
//        Pair('A', 'U'),
//        Pair('T', 'A')
//)
//
//fun transcribeToRna(dna: String): String {
//    return dna.map { dnaToRnaMap[it] }.filterNotNull().joinToString("")
//}
//
//
////=====================================================
//
//object RnaTranscription {
//
//    fun ofDna(input: String): String {
//        return input.map(::process).joinToString(separator = "");
//    }
//
//}
//
//private fun process(ch: Char): Char {
//    when (ch) {
//        'G' -> return 'C'
//        'C' -> return 'G'
//        'T' -> return 'A'
//        'A' -> return 'U'
//        else -> throw IllegalArgumentException("Not supported")
//    }
//}
//
////=====================================================
//
//fun transcribeToRna(input:String) = input.map{ dna -> when(dna){
//        'G' -> 'C'
//        'C' -> 'G'
//        'T' -> 'A'
//        'A' -> 'U'
//        else -> dna
//    }}.joinToString("")


////=====================================================
//fun transcribe(dna: Char) =
//        when(dna){
//            'G' -> 'C'
//            'C' -> 'G'
//            'T' -> 'A'
//            'A' -> 'U'
//            else -> dna
//        }
//
//fun transcribeToRna(input:String) = input.map(::transcribe).joinToString("")
//
//
//////=====================================================


val DNAToRNA = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')
fun transcribeToRna(input:String) = input.map{ DNAToRNA[it] }.joinToString("")




