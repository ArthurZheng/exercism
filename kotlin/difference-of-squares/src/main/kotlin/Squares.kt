class Squares(val inputNumber: Int){
    fun squareOfSum(): Int {
        return (1..inputNumber).fold(0) {acc, x -> x + acc } * (1..inputNumber).fold(0) {acc, x -> x + acc }
    }

    fun sumOfSquares(): Int {
        return (1..inputNumber).map { it -> it * it }.sum()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}