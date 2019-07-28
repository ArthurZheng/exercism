
object Prime {
    fun nth(i: Int): Int {
        require(i > 0)
        var counter = 2
        return generateSequence { (counter++) }
                .filter { it.isPrime() }
                .take(i).last()
    }

    private fun Int.isPrime() =
        (1..this).filter {
            this % it == 0
        } == listOf(1, this)
}





object Prime {
  fun nth(n: Int): Int {
    require(n > 0) {"There is no zeroth prime."}

    return primes().drop(n - 1).first()
  }
}

val primes = {
  var n = 2
  var acc: MutableList<Int> = mutableListOf()

  generateSequence {
    tailrec fun next(): Int {
      if (acc.none { n % it == 0 }) {
        acc.add(n)
        return n
      }
      else {
        n += 1
        return next()
      }
    }
    next()
  }
}



object Prime {
    fun nth(n: Int): Int {
        require (n > 0) { "There is no zeroth prime." }
        var pastPrimeNumbers = listOf(2).toMutableList()
        var currentInt : Int = 3
        while (pastPrimeNumbers.size < n) {
            if (pastPrimeNumbers.isEmpty() || pastPrimeNumbers.all { currentInt % it != 0 }) {
                pastPrimeNumbers.add(currentInt)
            }
            currentInt += 2
        }
        return pastPrimeNumbers.last()
    }
}


import kotlin.math.sqrt

object Prime {

    fun nth(primeNumber: Int): Int {
        require(primeNumber > 0) {"There is no zeroth prime."}
        return generateSequence(2, {nextPrime(it + 1)}).drop(primeNumber - 1).first()
    }

    private tailrec fun nextPrime(value: Int): Int = if (value.isPrime) value else nextPrime(value + 1)

    private val Int.isPrime: Boolean get() {
        if (this.isEven) return false

        val highestPossibleFactor = sqrt(this.toDouble()).toInt()
        return 3.rangeTo(highestPossibleFactor).all { this.rem(it) != 0 }
    }

    private inline val Int.isEven get() = this and 0x01 == 0
}



private fun Int.sqrt() = Math.sqrt(this.toDouble()).toInt()

object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(1, { it + 1 })
            .filterNot { value -> (2..value.sqrt()).any { value % it == 0 } }
            .elementAt(n)
    }
}



object Prime {
    fun nth(n: Int) : Int {
        require(n > 0, {"There is no zeroth prime."})
        var ret = mutableListOf<Int>(2)
        findPrime(n, 3, ret)
        return ret.last()
    }

    tailrec fun findPrime(n: Int, start: Int, l: MutableList<Int>) {
        if(l.size == n) return

        if(l.all {start % it != 0})
            l.add(start)

        findPrime(n, start + 2, l)
    }
}



import java.lang.Math.sqrt

object Prime {
    private val primes = generateSequence(2L) { it + 1 }.filter { n ->
        (2L..sqrt(n.toDouble()).toLong()).none { n % it == 0L }
    }

    fun nth(n: Int): Long {
        require(n > 0)
        return primes.elementAt(n - 1)
    }
}



object Prime {
    fun nth(i: Int): Int {
        require(i > 0)
        return generateSequence(2) { i -> i + 1 }
                .filter { isPrime(it) }
                .elementAt(i - 1)
    }

    private fun isPrime(number: Int): Boolean {
        val upperBound = Math.sqrt(number.toDouble()).toInt()
        return number == 2 || (2 .. upperBound)
                .none{ number.rem(it) == 0}
    }
}



/**
 * Created by bolot on 7/3/17.
 */
class Prime {
    companion object {
        fun nth(order: Int): Int {
            if (order < 1)
                throw IllegalArgumentException()
            var primes = listOf<Int>()
            var index = 0
            var n = 1
            while (index < order) {
                n++
                if (primes.find { n % it == 0 } == null) {
                    primes += n
                    index++
                }
            }
            return n
        }
    }
}




object Prime {
    fun nth(i: Int): Int {
        require(i > 0) {"There is no zeroth prime."}
        if (i < 2) return 2

        return generateSequence(3) {it + 2}
                .filter { it.isPrime() }
                .take(i - 1).last()
    }

    private fun Int.isPrime(): Boolean {
        val highestPossibleFactorial = (Math.sqrt(this.toDouble()) + 1).toInt()
        return (3..highestPossibleFactorial step 2).none { this % it == 0 }
    }

}




object Prime {

    fun primeTest(n: Int, primtList: MutableList<Int>): Boolean{
        return primtList.any { n % it == 0 }
    }
    fun nth(n: Int): Int {
        require(n > 0) {"There is no zeroth prime."}

        var primtList = mutableListOf<Int>(2)

        var i: Int = 2
        while(primtList.size < n){
            if (!primeTest(i, primtList)){
                primtList.add(i)
            }
            i++
        }

        return primtList.last()
    }
}



import java.lang.IllegalArgumentException

object Prime {
    fun nth(i: Int): Int {
        require(i > 0) { throw IllegalArgumentException("There is no zeroth prime.")}
        val primes = mutableListOf(2)
        var count = 3
        while(primes.size != i) {
            if(primes.all { count.rem(it) != 0 })
                primes.add(count)
            count ++
        }
        return primes.last()
    }
}



object Prime {
    fun nth(n: Int): Long {
        require(n > 0) {"There is no zeroth prime."}
        return primes().elementAt(n)
    }

    private fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                    .filter { n -> n > 0 && ((2 until n).none { i -> n % i == 0L }) }
                    .forEach { yield(it) }
        }
    }
}



package Prime

fun nth(n: Int): Int {
    require(n > 0) { "Need an ordinal number, not n=$n" }
    return primeAtOrdinal(n)
}

private fun primeAtOrdinal(n: Int) = primes.elementAt(n)

val primes = generateSequence(1 to setOf<Int>()) { (p, primes) ->
    generateSequence(p + 1) { it + 1 }
    .filter({ n -> primes.none({ n % it == 0 }) })
    //.onEach { println("$it") }  // I hoped this sequence would be memoized, but logging says not: we re-filter 2 over and over.
    .map { p -> p to (primes + setOf(p)) }
    .first()
}
.map { it.first }

// To see println output, edit build.gradle to have test.testLogging.showStandardStreams = true







private fun Int.sqrt() = Math.sqrt(this.toDouble()).toInt()

object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(1, { it + 1 })
            .filter { value -> (2..value.sqrt()).none { value % it == 0 } }
            .elementAt(n)
    }
}




private fun Int.sqrt() = Math.sqrt(this.toDouble()).toInt()

object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(1) { it + 1 }
            .filter { value -> (2..value.sqrt()).none {
                println("value is $value")
                println("it is $it")
                value % it == 0 }
            }
            .elementAt(n)
    }
}


private fun Int.sqrt() = Math.sqrt(this.toDouble()).toInt()

object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(1) { it + 1 }
            .filter { value -> (2..value.sqrt()).none {
                value % it == 0 }
            }
            .elementAt(n)
    }
}