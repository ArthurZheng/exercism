//object SumOfMultiples {
//    fun sum(multiples: Set<Int>, n: Int) =
//            multiples.flatMap { (0 until n).step(it) }
//                    .toSet()
//                    .sum()
//}

//package SumOfMultiples
//fun sum(multiples: Set<Int>, n: Int): Int {
////    return multiples.flatMap{ (0 until n).step(it)}.toSet().sum()
//    return (1 until n).filter{ num -> multiples.any{ num % it == 0}}.sum()
//}


//object SumOfMultiples {
//    fun sum(set: Set<Int>, num: Int) = (1 until num).filter { n -> set.any { n % it == 0 } }.sum()
//}



//object SumOfMultiples{
//    fun sum(list: Set<Int>, number: Int): Int = (0..(number-1)).filter { list.any { n -> it % n == 0 } }.sum()
//}



fun Int.factorsList(): List<Int> =
    (1..this/2).filter { this % it == 0 } + this

val factors = 24.factorsList()
println(factors)

inputSet.map { it -> (1..range).filter{ number -> it % number == 0 } }.sum()


flatMap


object SumOfMultiples {
    fun sum(multiples: Set<Int>, n: Int) =
            multiples.map { (0 until n).step(it) }
                    .flatMap { it }
                    .toSet()
                    .sum()
}


object SumOfMultiples {
  fun sum(multiples: Set<Int>, limit: Int): Int =
    multiples.flatMap { 0 until limit step it }.toSet().sum()
}


object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
      ((multiples.min() ?: limit) until limit)
          .filter { i -> multiples.any { i % it == 0 } }
          .sum()
}





object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int =
        (1 until limit)
            .filter(multiples::anyFactors)
            .sum()
}

fun Set<Int>.anyFactors(number: Int): Boolean = this.any { factor -> factor.isFactorOf(number) }
fun Int.isFactorOf(number: Int): Boolean = number % this == 0



package SumOfMultiples

fun sum(baseNumbers: Set<Int>, n: Int): Int {
    return baseNumbers.
            flatMap { it.multiplesLessThan(n) }.
            toSet().
            sum()
}

fun Int.multiplesLessThan(n: Int): Set<Int> = (this until n step this).toSet()




class SumOfMultiples {
    companion object {
        fun sum(multiples: Set<Int>, upperBound: Int): Int {
            return (1 until upperBound).filter {num -> multiples.any { num % it == 0 } }.sum()
        }
    }
}





object SumOfMultiples {
    fun sum(bases: Set<Int>, upto: Int): Int {
        return bases
                .flatMap { it.rangeTo(upto - 1).step(it) }
                .distinct()
                .sum()
    }
}


object SumOfMultiples {
    fun sum(set: Set<Int>, num: Int) = (1 until num).filter { n -> set.any { n % it == 0 } }.sum()
}



// map + flatten() = flatMap()
object SumOfMultiples {
    fun sum(multiplesOf: Set<Int>, below: Int): Int {
        return multiplesOf.map { multiple ->
            (multiple until below).filter { it % multiple == 0 }
        }.flatten().distinct().sum()
    }

}


package SumOfMultiples
fun sum(setOfNumbers: Set<Int>, inputNumber: Int): Int {
	return (1 until inputNumber).filter{ number -> setOfNumbers.any{ number % it == 0 } }.sum()
}