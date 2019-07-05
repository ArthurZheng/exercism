
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) {"java.lang.RuntimeException"}
    val factorsListSum = naturalNumber.factorsList().sum()
    return when{
        factorsListSum == naturalNumber -> Classification.PERFECT
        factorsListSum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT

    }
}

private fun Int.factorsList() = (1.until(this) / 2).filter{ this % it == 0 }


//enum class Classification { DEFICIENT, PERFECT, ABUNDANT }
//
//fun classify(naturalNumber: Int) = naturalNumber
//        .let { require(it > 0); it }
//        .compareTo(naturalNumber.factors.sum())
//        .let {
//            when {
//                it < 0 -> Classification.ABUNDANT
//                it == 0 -> Classification.PERFECT
//                else -> Classification.DEFICIENT
//            }
//        }
//
//private val Int.factors: List<Int>
//    get() = (1..this / 2).fold(emptyList()) { factors, i -> if (this % i == 0) factors.plus(i) else factors }



enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int) : Classification {
    require(n > 0) { "Argument must be > 0" }

    val aliquotSum = (1..n / 2)
            .sumBy { if (n % it == 0) it else 0 }

    return aliquotSum.compareTo(n).let {
        when {
            it < 0  -> Classification.DEFICIENT
            it == 0 -> Classification.PERFECT
            else    -> Classification.ABUNDANT
        }
    }
}




enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification = naturalNumber.aliquotSum().let {
    when {
        it < naturalNumber -> Classification.DEFICIENT
        it == naturalNumber -> Classification.PERFECT
        else -> Classification.ABUNDANT
    }
}

fun Int.aliquotSum(): Int {
    require(this > 0)
    return (1..this / 2).filter { it.isFactorOf(this) }.sum()
}

fun Int.isFactorOf(n: Int): Boolean = n % this == 0




enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) {"$naturalNumber is not a natural number"}
    val aliquotSum = (1..naturalNumber / 2)
            .filter { naturalNumber % it == 0 }.sum()
    return when {
        aliquotSum > naturalNumber -> Classification.ABUNDANT
        aliquotSum == naturalNumber -> Classification.PERFECT
        aliquotSum < naturalNumber -> Classification.DEFICIENT
        else -> throw RuntimeException()
    }
}




enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber < 1) throw RuntimeException()
    val sum = (1..naturalNumber-1).filter { i -> (naturalNumber % i == 0) }.fold(0, {soma, i -> soma + i})
    return when{
        sum == naturalNumber -> Classification.PERFECT
        sum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}



enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int) : Classification {
    require(n > 0) { "Argument must be > 0" }

    val aliquotSum = (1..n / 2)
            .sumBy { if (n % it == 0) it else 0 }

    return aliquotSum.compareTo(n).let {
        when {
            it < 0  -> Classification.DEFICIENT
            it == 0 -> Classification.PERFECT
            else    -> Classification.ABUNDANT
        }
    }
}




enum class Classification { DEFICIENT, PERFECT, ABUNDANT }

fun classify(naturalNumber: Int) = naturalNumber
        .let { require(it > 0); it }
        .compareTo(naturalNumber.factors.sum())
        .let {
            when {
                it < 0 -> Classification.ABUNDANT
                it == 0 -> Classification.PERFECT
                else -> Classification.DEFICIENT
            }
        }

private val Int.factors: List<Int>
    get() = (1..this / 2).fold(emptyList()) { factors, i -> if (this % i == 0) factors.plus(i) else factors }









