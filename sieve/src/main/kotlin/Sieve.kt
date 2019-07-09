import kotlin.coroutines.experimental.buildSequence

object Sieve {
  fun primesUpTo(limit: Int) = primes().takeWhile { it <= limit }.toList()

  fun primes(n: Int = 2): Sequence<Int> = buildSequence<Int> {
    yield(n)
    yieldAll(primes(n + 1).filter { x: Int -> x % n != 0 })
  }
}




object Sieve {
    fun primesUpTo(number: Int) = (2..number).filter { it.isPrime() }
}

private fun Int.isPrime() = (2..this / 2).none { this % it == 0 }



object Sieve {
    fun primesUpTo(limit: Int): List<Int> {
        val candidates = (2..limit).toList()
        return candidates.fold(candidates, { acc, value -> acc.filterNot { it != value && it % value == 0 } })
    }
}


object Sieve {
    fun primesUpTo(number: Int): List<Int> {
        val candidates = (2..number).toList()
        return candidates.fold(candidates, { acc, candidate -> acc.filterNot { it > candidate && it % candidate == 0} })
    }
}




object Sieve {
    fun primesUpTo(max: Int): List<Int> = primes((2..max).toList())

    tailrec private fun primes(nexts: List<Int>): List<Int> = when (nexts.size) {
        0, 1 -> nexts
        else -> {
            val current = nexts[0]
            nexts.take(1).plus(primes(nexts.drop(1).filter { it.rem(current) != 0 }))
        }
    }
}




object Sieve {

    fun primesUpTo(limit: Int): List<Int> {
        return if (limit < 2) emptyList()
        else {
            val sieve = (2..limit).toHashSet()
            (2..limit).asSequence().filter { sieve.contains(it) }. forEach { num -> (num+1..limit).forEach { if (sieve.contains(it) && it % num == 0) sieve.remove(it) } }
            sieve.toList()
        }
    }
}




object Sieve {
    fun primesUpTo(limit: Int): List<Int> =
        when {
          limit < 2 -> listOf()
          else -> {
            val range = (2..limit)
            val primes = range.associate { Pair(it, true) }.toMutableMap()
            range.map { rangeValue ->
              if (primes[rangeValue]!!) {
                ((rangeValue + rangeValue)..limit step rangeValue).forEach { primes[it] = false }
              }
            }
            primes.filter { pair -> pair.value }.keys.toList()
          }
        }
}





fun Int.sqr() = this * this

object Sieve {
        fun primesUpTo(limit: Int): List<Int>{
            var sieve = IntArray(limit+1, {it})
            fun remove(i: Int) = (i.sqr()..limit).step(i).forEach{sieve[it] = 0}
            (2..limit).forEach{if (sieve[it] > 0) remove(it)}
            return sieve.filter{it >= 2}
        }
}




object Sieve {
    fun primesUpTo(i: Int) = (2..i).let { range ->
        range.minus(range.flatMap { n -> (2..i / n).map { it * n } })
    }
}



object Sieve {
    fun primesUpTo(limit: Int) = findPrimes(2, (2..limit).toList())

    private fun findPrimes(n: Int, potentialPrimes: List<Int>): List<Int> {
        return potentialPrimes.filterNot { it > n && it % n == 0 }.let { potentials ->
            potentials.firstOrNull { it > n }?.let { findPrimes(it, potentials) } ?: potentials
        }
    }
}




object Sieve {
    fun primesUpTo(number: Int): List<Int> {
        return sieve((2..number).toList())
    }

    fun sieve(numbers: List<Int>): List<Int> = when(numbers.isEmpty()) {
        true -> emptyList<Int>()
        else -> listOf(numbers.first()).plus(sieve(numbers.drop(1).filter { it % numbers.first() != 0 }))
    }
}



object Sieve {
    private fun sieve(l: List<Int>): List<Int> = if (l.isEmpty()) l
        else l.take(1) + sieve(l.drop(1) - (l.first()..l.last()).step(l.first()).drop(1).toList())
    fun primesUpTo(n: Int): List<Int> = sieve((2..n).toList())
}



object Sieve{

    fun primesUpTo(num:Int):List<Int>{
        return (2..num).fold(listOf<Int>()){acc,number ->
            val factorFound = (2..number/2).find{ factor ->
                number % factor == 0
            }
            
            if(factorFound == null) acc + number else acc
        }
    }
}





