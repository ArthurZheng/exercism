//class Squares(val inputNumber: Int){
//    fun squareOfSum(): Int {
//        return (1..inputNumber).fold(0) {acc, x -> x + acc } * (1..inputNumber).fold(0) {acc, x -> x + acc }
//    }
//
//    fun sumOfSquares(): Int {
//        return (1..inputNumber).map { it -> it * it }.sum()
//    }
//
//    fun difference(): Int {
//        return squareOfSum() - sumOfSquares()
//    }
//}

//
//import kotlin.math.pow
//
////private fun Int.squared() = this * this
//private fun Int.squared() = this.toDouble().pow(2).toInt()
//class Squares(private val value: Int) {
//    fun squareOfSum() = 1.rangeTo(value).sum().squared()
//
////    fun sumOfSquares() = 1.rangeTo(value).map(Int::squared).sum()
////    fun sumOfSquares() = 1.rangeTo(value).sumBy(Int::squared)
//    fun sumOfSquares() = 1.rangeTo(value).sumBy{ it.squared()}
//    fun difference() = squareOfSum() - sumOfSquares()
//}


//import kotlin.math.pow
//
////private fun Int.square() = this * this
//private fun Int.square() = this.toDouble().pow(2).toInt()
//
//class Squares (private val num: Int) {
//    fun squareOfSum() = 1.rangeTo(num).sum().square()
////    fun sumOfSquares() = 1.rangeTo(num).sumBy(Int::square)
////    fun sumOfSquares() = (1..num).map{ it.square() }.sum()
//    fun sumOfSquares() = (1..num).map { it.square() }.sum()
//    fun difference() = squareOfSum() - sumOfSquares()
//}



//private fun Int.square() = this * this
//
//val intSeq = generateSequence(1) { (it + 1) }
//val squareSeq = intSeq.map(Int::square)
//
//class Squares(val i: Int) {
//
//    val sum = { seq: Sequence<Int> -> seq.take(i).sum() }
//
//    fun squareOfSum() = sum(intSeq).square()
//
//    fun sumOfSquares() = sum(squareSeq)
//
//    fun difference() = squareOfSum() - sumOfSquares()
//}



private fun Int.square() = this * this

class Squares (private val inputNumber: Int) {
    fun squareOfSum() = (1..inputNumber).sum().square()
    fun sumOfSquares() = (1..inputNumber).sumBy(Int::square)
    fun difference() = squareOfSum() - sumOfSquares()
}














