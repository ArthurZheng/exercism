class Series(val digits: String) {
  init {
    require(digits.all { it.isDigit() })
  }

  fun getLargestProduct(n: Int): Int {
    require(n <= digits.length)
    return if (n == 0 || digits.isEmpty()) 1 else maxProduct(n)
  }

  private fun maxProduct(n: Int) =
      digits.windowed(n, 1) {
        it.fold(1, { acc, v -> acc * (v - '0') })
      }.max() ?: 0
}



class Series(val value: String) {
    init {
        require(value.all { it.isDigit() })
    }
    fun getLargestProduct(span: Int) = when {
        span > value.length -> throw IllegalArgumentException("span must be less than or equal to series length")
        span == 0 -> 1
        else -> value.map { it.toString().toInt() }.windowed(size = span).map { it.multiply() }.max()!!
    }
}

private fun List<Int>.multiply() = reduce { sum, i -> sum * i }







class Series(private val digitString: String) {
    init { require(digitString.matches("\\d*".toRegex())) }

    fun getLargestProduct(spanLength: Int) = when {
        spanLength == 0 -> 1
        spanLength > digitString.length -> throw IllegalArgumentException()
        else -> digitString.windowed(spanLength) {
                    it.fold(1) { product, digitChar -> product * Character.getNumericValue(digitChar) }
                }.max() ?: 1
    }
}




class Series(val str: String) {
  val seq = str.map { it.toInt() - '0'.toInt() }

  init {
    require(str.all(Char::isDigit))
  }

  fun getLargestProduct(len: Int): Int? {
    require(len in 0..seq.size)

    return (0..(seq.size - len)).map { seq.subList(it, it + len).product() }.max()
  }

}

private fun List<Int>.product() = this.fold(1, Int::times)





class Series ( val digits : String ) {
  init {
    require(digits.all{ it.isDigit() })
  }

  fun getLargestProduct( length : Int ) : Int {
    require(length <= digits.length)
    if ( length == 0 ) return 1

    return digits.windowed( length )
      .map { product(it) }
      .max()!!
  }

  private fun product( substring : String ) : Int =
    substring.map{ it.asDigit() }
      .reduce { x, y -> x * y }

}

fun Char.asDigit() : Int = this.toString().toInt()






class Series(val series: String) {

    init {
        require(series.all(Char::isDigit))
    }

    fun getLargestProduct(n: Int): Int {
        require(n >= 0 && n <= series.length)

        return if (n == 0) 1
        else series.map(Character::getNumericValue)
            .windowed(n)
            .map { it.reduce { acc, i -> acc * i } }
            .max() ?: 1
    }
}




class Series(val input: String) {

   init {
      require(input.matches(Regex("[0-9]*")))
   }

   fun getLargestProduct(span: Int): Long {
      require(span in 0..input.length)
      if (input.isEmpty()) return 1
      return (0..input.length - span)
            .map { i ->
               input.slice(i..i + span - 1)
                     .map { it.toString().toLong() }
                     .reduce { a, b -> a * b }
            }
            .max()
            ?: 0L
   }

}




class Series(input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    private val arr = input.map { it.toInt() - '0'.toInt() }


    fun getLargestProduct(len: Int): Int? {
        require(len <= arr.size)
        return (0..(arr.size - len)).map { arr.subList(it, it + len).product() }.max()
    }

    private fun List<Int>.product() = this.fold(1) { acc, num -> acc * num }
}




class Series(private val number: String) {

    init {
        require("[0-9]*".toRegex().matches(number))
    }

    fun getLargestProduct(step: Int) =
            when {
                step == 0 -> 1
                number.length < step -> throw IllegalArgumentException()
                else -> number.windowed(size = step) {
                    it.fold(1, { product, digit -> product * digit.toString().toInt() })
                }.max()
            }
}






fun List<Int>.multiply() = this.reduce{total, i -> total * i}
fun Char.toDigit() = this.toString().toInt()

class Series(val input: String) {
    init { require(input.all {it.isDigit()}) }

    fun getLargestProduct(windowSize: Int): Int{
        if (windowSize == 0) return 1
        require(input.length >= windowSize)
        return input
                .map {it.toDigit()}
                .windowed(windowSize, 1)
                .map {it.multiply()}
                .max()!!
    }
}





class Series(str: String) {
    private val arr = str.map { require(Character.isDigit(it)); Character.getNumericValue(it) }

    fun getLargestProduct(span: Int) = if (span == 0) 1 else {
        require(arr.isNotEmpty()) { "digits must not be empty" }
        require(span <= arr.size) { "span must not be larger than number of digits" }
        arr.windowed(span) { it.reduce(Int::times) }.max()!!
    }
}





class Series(private val digits: List<Int>) {
    constructor(digitStr: String) : this(digitStr.map { it.asInt() })

    fun getLargestProduct(span: Int) =
            require(span <= digits.size).let {
                (0..(digits.size - span))
                        .map { digits.subList(it, it + span) }
                        .map { it.fold(1) { product, digit -> product * digit } }
                        .sorted()
                        .last()
            }
}

private fun Char.asInt() = toString().toInt(



class Series(val numberString: String) {
    fun getLargestProduct(n: Int): Int {
        val len = numberString.length
        require(n in 0..len)
        if(n==0) return 1

        return (0..len - n).map { numberString.substring(it, it + n) }
                .map { product(it) }.max()!!
    }

    private fun product(s: String): Int = s.map { it.toInt() - 48 }
            .fold(1, { p, n -> p * n })
}





data class Series(val s: String) {
    fun getLargestProduct(n: Int): Int {
        require(n <= s.length)

        val ret = s.windowedSequence(n)
                .map { it.fold(1) { acc, c -> acc * (c - '0') }}
                .max()

        return ret!!.toInt()
    }
}