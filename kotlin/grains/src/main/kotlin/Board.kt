import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(chessSquareNumber: Int):BigInteger {
        require(chessSquareNumber in 1..64) {"Only integers between 1 and 64 (inclusive) are allowed"}
        return BigInteger.valueOf(2).pow(chessSquareNumber - 1)
    }

    fun getTotalGrainCount() = BigInteger.valueOf(2).pow(64) - BigInteger.ONE
}



import java.math.BigInteger

object Board {
    private val squareNumber = 64

    fun getGrainCountForSquare(i: Int): BigInteger {
        require(i in 1..squareNumber) {
            "Only integers between 1 and 64 (inclusive) are allowed"
        }
        return BigInteger.valueOf(2).pow(i - 1)
    }

    fun getTotalGrainCount() = BigInteger.valueOf(2).pow(squareNumber) - BigInteger.ONE
}



import java.math.BigInteger

object Board {
  val limit = 64

  fun getGrainCountForSquare(n: Int): BigInteger {
    require(n in 1..limit) { "Only integers between 1 and 64 (inclusive) are allowed" }
    return grainCount(n - 1)
  }

  fun getTotalGrainCount() = grainCount().dec()

  private fun grainCount(n: Int = limit) = 2.toBigInteger().pow(n)
  private fun grainCount(n: Int = limit) = BigInteger.valueOf(2).pow(n)
}



import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(n: Int): BigInteger {
        if (n !in 1..65) throw IllegalArgumentException()
        return BigInteger.ONE shl (n - 1)
    }
    fun getTotalGrainCount() = (BigInteger.ONE shl 64) - BigInteger.ONE
}



import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(square: Int): BigInteger = require(square in 1..64) { "Only integers between 1 and 64 (inclusive) are allowed" }
            .let { BigInteger.valueOf(2).pow(square - 1) }

    fun getTotalGrainCount(): BigInteger = (1..64).also { println("Start: ${System.currentTimeMillis()}") }.map { getGrainCountForSquare(it) }
            .fold(BigInteger.ZERO) { total, sq -> total + sq }.also { println("Start: ${System.currentTimeMillis()}") }
}







fun Int.toBigInteger() = BigInteger.valueOf(this.toLong())
infix private fun Int.pow(power: Int) = this.toBigInteger().pow(power)





import java.math.BigInteger

object Board {
    fun  getGrainCountForSquare(squareNum: Int): BigInteger? {
        require(squareNum in 1..64, { "Only integers between 1 and 64 (inclusive) are allowed" } )

        return BigInteger.valueOf(2L).pow(squareNum -1)
    }

    fun getTotalGrainCount(): BigInteger = (1..64).mapNotNull {
        getGrainCountForSquare(it)
    }.toList().sum()
}

private fun List<BigInteger>.sum(): BigInteger {
    return this.reduce { acc, bigInteger -> acc.add(bigInteger) }
}






import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(square: Int): BigInteger {
        require(square in (1..64)) { "Only integers between 1 and 64 (inclusive) are allowed" }

        // Return 2 ^ (square - 1)
        return BigInteger.ONE.shiftLeft(square - 1)
        return BigInteger.valueOf(2).pow( square - 1)
        return 2.toBigInteger.pow(square -1)

    }

    fun getTotalGrainCount() = BigInteger.ONE.shiftleft(64) - BigInteger.ONE
    fun getTotalGrainCount() = BigInteger.ONE.shiftleft(64).dec()
    fun getTotalGrainCount() = BigInteger.valueOf(2).pow(64).dec()
    fun getTotalGrainCount() = BigInteger.valueOf(2).pow(64).minus(BigInteger.ONE)
    fun getTotalGrainCount() = BigInteger.valueOf(2).pow(64) - BigInteger.ONE

    fun getTotalGrainCount(): BigInteger {
        val lastSquareCount = getGrainCountForSquare(64)
        return lastSquareCount.shiftLeft(1).minus(BigInteger.ONE)
    }

    fun getTotalGrainCount() = (1..64).map { getGrainCountForSquare(it) }
            .reduce { acc, bigInteger -> acc + bigInteger }
}






package Board

import java.math.BigInteger

fun getGrainCountForSquare(square: Int): BigInteger {
    require(square >= 1 && square <= 64) { "Only integers between 1 and 64 (inclusive) are allowed" }
    return BigInteger.valueOf(2L).pow(square - 1)
}

fun getTotalGrainCount(): BigInteger {
    val lastSquareCount = getGrainCountForSquare(64)
    return lastSquareCount.shiftLeft(1).minus(BigInteger.ONE)
}



package Board

import java.math.BigInteger

fun getGrainCountForSquare(square: Int): BigInteger {
    require(square >= 1 && square <= 64) { "Only integers between 1 and 64 (inclusive) are allowed" }
    return BigInteger.valueOf(2L).pow(square - 1)
}

fun getTotalGrainCount(): BigInteger {
    val lastSquareCount = getGrainCountForSquare(64)
    return BigInteger.valueOf(2).pow(64) - BigInteger.ONE    return lastSquareCount.shiftLeft(1).minus(BigInteger.ONE)
    return BigInteger.valueOf(2).pow(64) - BigInteger.ONE
}








import java.math.BigInteger
import java.math.BigInteger.ZERO
import java.math.BigInteger.ONE

object Board {
  val MAX_POS: Int = 64

  fun getGrainCountForSquare(pos: Int): BigInteger {
    require(pos in 1..MAX_POS) { "Only integers between 1 and ${MAX_POS} (inclusive) are allowed" }

    return ONE shl (pos - 1)
  }

  fun getTotalGrainCount(): BigInteger =
    (1..MAX_POS).map { getGrainCountForSquare(it) }.fold(ZERO, BigInteger::plus)

}





import java.math.BigInteger

object Board {
    private val range = 1..64
    private val two = 2.toBigInteger()

    fun getGrainCountForSquare(squares: Int): BigInteger {
        require(range.contains(squares)) { "Only integers between 1 and 64 (inclusive) are allowed" }
        return two.pow(squares - 1)
    }

    fun getTotalGrainCount() = two.pow(range.last).minus(BigInteger.ONE)
}





import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(square: Int): BigInteger {
        require(square in 1..64) { "Only integers between 1 and 64 (inclusive) are allowed" }
        return BigInteger("2").pow(square - 1)
    }

    fun getTotalGrainCount(): BigInteger = BigInteger("2").pow(64).minus(BigInteger.ONE)
}




import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(n: Int): BigInteger {
        require(n in 1..64) {
            "Only integers between 1 and 64 (inclusive) are allowed"
        }
        return 2.toBigInteger().pow(n - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..64).fold(0.toBigInteger()) {
            sum, square -> sum + getGrainCountForSquare(square)
        }
    }
}




