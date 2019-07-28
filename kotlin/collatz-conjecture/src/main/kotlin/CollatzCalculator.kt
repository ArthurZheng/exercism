object CollatzCalculator {
    fun computeStepCount(number: Int): Int {
        var numberCopy = number
        require(numberCopy > 0) {"Only natural numbers are allowed"}
        var counter: Int = 0
        while(numberCopy != 1) {
            when {
                numberCopy.isOdd() -> numberCopy = numberCopy * 3 + 1
                else -> numberCopy = numberCopy / 2
            }
            counter++
        }
        return counter
    }

    private fun Int.isOdd() = this % 2 != 0
    private fun Int.isOdd(): Boolean = this.rem(2) != 0
    private fun Int.isEven() = this.rem(2) == 0

}


class CollatzCalculator {
    companion object {
        tailrec fun computeStepCount(start: Int, offset: Int = 0): Int = when {
            start < 1 -> throw IllegalArgumentException("Only natural numbers are allowed")
            start == 1 -> offset
            else ->  {
                val newValue = if (start % 2 == 0) start / 2 else 3 * start + 1
                computeStepCount(newValue, offset + 1)
            }
        }
    }
}



class CollatzCalculator {
    companion object {
        fun computeStepCount(n: Int): Int {
            require( n > 0 ) { "Only natural numbers are allowed" }

            var steps = 0
            var n = n

            while (n != 1) {
                steps++
                if (n % 2 == 0) n /= 2 else n = n * 3 + 1
            }

            return steps
        }
    }
}




    // 29ms -- using pure recursion
    fun computeStepCount2(start : Int ) : Int {
        require( start > 0) { "Only natural numbers are allowed." }

        return when {
            start == 1 -> 0
            start % 2 == 0 -> 1 + computeStepCount2(start / 2)
            else -> 1 + computeStepCount2(start * 3 + 1)
        }
    }


    // 32ms -- using tail recursion
    fun computeStepCount3(start: Int): Int {
        require(start > 0) { "Only natural numbers are allowed" }
        var steps = 0

        // signals complier to replace with iterator
        tailrec fun tailCount(num: Int): Int {
            steps++
            return when {
                num == 1 -> steps - 1
                num % 2 == 0 -> tailCount(num / 2)
                else -> tailCount(num * 3 + 1)
            }
        }

        return tailCount(start)
    }





object CollatzCalculator {
    fun computeStepCount(i: Int): Int {
        require(i > 0) { IllegalArgumentException("Only natural numbers are allowed") }
        return generateSequence(i) { if (it.rem(2) == 0) it / 2 else 3 * it + 1 }
                .takeWhile { it != 1 }
                .count()
    }
}



object CollatzCalculator {
    fun computeStepCount(n: Int): Int {
        require(n>0) { "Only natural numbers are allowed" }
        var num: Int = n
        var times: Int = 0
        while(num!=1) {
            when (num%2) {
                0 -> num = num/2
                else -> num = 3*num+1
            }
            times += 1
        }
        return times
    }
}




object CollatzCalculator {
    tailrec fun computeStepCount(i: Int, acc: Int = 0): Int {
        require(i > 0) { "Only natural numbers are allowed" }

        return when {
            i == 1 -> acc
            i.isOdd -> computeStepCount(i / 2, acc + 1)
            else -> computeStepCount(3 * i + 1, acc + 1)
        }
    }

    private val Int.isOdd get() = this % 2 == 0
}



object CollatzCalculator {
    fun computeStepCount(num: Int): Int {
        require(num >= 1) { "Only natural numbers are allowed" }
        return generateSequence(num) { n -> if (n % 2 == 0) n / 2 else n * 3 + 1 }.indexOf(1)
    }
}






package CollatzCalculator

import java.lang.IllegalArgumentException

private fun getNext(n: Int) = when {
    n % 2 == 0 -> n / 2
    else -> 3 * n + 1
}

fun computeStepCount(n: Int): Int {
    if (n <= 0) throw IllegalArgumentException("Only natural numbers are allowed")

    return generateSequence(n, ::getNext)
    .takeWhile { it != 1 }
    .count()
}




object CollatzCalculator {

    fun computeStepCount(num: Int): Int {
        require(num > 0) {"Only natural numbers are allowed"}
        return generateSequence(num, ::nextStep).takeWhile{it > 1}.count()
    }

    private fun nextStep(curr: Int): Int =
            if (curr % 2 == 0) curr.div(2) else curr.times(3).plus(1)

}



object CollatzCalculator {
    fun computeStepCount(init: Int): Int {
        require(init > 0) {"Only natural numbers are allowed"}
        return generateSequence(init, ::nextStep).takeWhile{it > 1}.count()
    }

    fun nextStep(curr: Int): Int =
        if (curr % 2 == 0) curr.div(2) else curr.times(3).plus(1)
}



object CollatzCalculator {
    fun computeStepCount(n: Int) = if (n > 0) computeStepCount(n, 0) else throw IllegalArgumentException("Only natural numbers are allowed")

    private tailrec fun computeStepCount(n: Int, acc: Int): Int = when {
        n == 1 -> acc
        n.isEven() -> computeStepCount(n / 2, acc + 1)
        else -> computeStepCount(3 * n + 1, acc + 1)
    }
}

private fun Int.isEven() = this.rem(2) == 0



class CollatzCalculator {

 companion object {
     fun computeStepCount(number: Int): Int {
         require(number > 0) { "Only natural numbers are allowed" }
         return calculate(number, 0)
     }

     private tailrec fun calculate(total: Int, count: Int) : Int = when {
         total == 1 -> count
         total % 2 == 0 -> calculate(total / 2, count+1)
         else -> calculate((3 * total) + 1, count + 1)
     }
 }

}



object CollatzCalculator {

    fun computeStepCount(number: Int): Int {
        require(number > 0) { "Only natural numbers are allowed." }
        return collatzFormulaWithStepCount(number, 0)
    }

    private tailrec fun collatzFormulaWithStepCount(number: Int, count: Int): Int = when {
        number == 1 -> count
        number % 2 == 0 -> collatzFormulaWithStepCount(number / 2, count + 1)
        else -> collatzFormulaWithStepCount(3 * number + 1, count + 1)
    }
}








