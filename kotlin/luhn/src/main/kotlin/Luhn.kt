package Luhn
fun isValid(inputString: String): Boolean {
    return if (!isLegal(inputString)) false else {
        (sanitiseInput(inputString).reversed().mapIndexed{ idx, value -> if( idx % 2 == 1 ) transformNumber(value) else value }.sum()) % 10 == 0
    }
}

private fun isLegal(input:String) = input.filter { it.isDigit() }.length > 1 && input.all { it.isDigit() || it ==' '}

private fun sanitiseInput(input: String): List<Int> {
    return Regex("[0-9]").findAll(input).map { it.groupValues[0]}.map { it.toInt() }.toList()
}

private fun transformNumber(num: Int): Int {
	var doubledNum = num * 2
	if (doubledNum > 9)  doubledNum = doubledNum - 9
    return  doubledNum
}


object Luhn {
    fun isValid(s: String): Boolean =
        if (!isLegal(s))  false
        else  s.filter { it.isDigit() }
                .map { it.toString().toInt() }
                .reversed()
                .mapIndexed(this::doubleAndNormalize)
                .sum() % 10 == 0

    private fun doubleEven(index: Int, e: Int) = if (index % 2 == 1) e * 2 else e
    private fun normalize(i: Int) = if (i > 9) i - 9 else i
    private fun doubleAndNormalize(index: Int, e: Int) = normalize(doubleEven(index, e))
    private fun isLegal(input:String) = input.filter { it.isDigit() }.length > 1 && input.all { it.isDigit() || it ==' '}
//    private fun isLegal(input:String) = input.trim().length > 1 && input.all{  it.isDigit() || it == ' '}
}



object Luhn {

	fun isValid(inputString: String): Boolean {
		return if (!isLegal(inputString)) {
			false
		} else {
			inputString.filter{ it.isDigit() }
//					.map{ it -> Character.getNumericValue(it)}
//					.map{Character.getNumericValue(it)}
					.map(Character::getNumericValue)
					.reversed()
//					.mapIndexed(this::doubleAndNormalise)
					.mapIndexed{idx, valuee -> doubleAndNormalise(idx, valuee)}
					.sum() % 10 == 0
		}
	}

	private fun isLegal(input:String) = input.trim().length > 1 && input.all{ it.isDigit() || it == ' '}
	private fun doubleAndNormalise(idx: Int, valuee: Int) = normaliseNumber(doubleOther(idx, valuee))
	private fun doubleOther(idx: Int, valuee: Int) = if (idx % 2 == 1) valuee * 2 else valuee
	private fun normaliseNumber(num: Int) = if (num > 9) num - 9 else num
}




object Luhn {

	fun isValid(inputString: String): Boolean {
		return if (!isLegal(inputString)) {
			false
		} else {
			inputString.filter{ it.isDigit() }
					.map{Character.getNumericValue(it)}
					.reversed()
					.mapIndexed{idx, valuee -> doubleAndNormalise(idx, valuee)}
					.sum() % 10 == 0
		}
	}

	private fun isLegal(input:String) = input.trim().length > 1 && input.all{ it.isDigit() || it == ' '}
	private fun doubleAndNormalise(idx: Int, valuee: Int) = normaliseNumber(doubleOther(idx, valuee))
	private fun doubleOther(idx: Int, valuee: Int) = if (idx % 2 == 1) valuee * 2 else valuee
	private fun normaliseNumber(num: Int) = if (num > 9) num - 9 else num
}







Character.getNumericValue

fun Char.getDigit() = this.toInt() - 48
object Luhn {
    fun isValid(sin: String): Boolean {
        val cleanInput = sin.filterNot { it.isWhitespace() }
        val isValid = cleanInput.length > 1 && cleanInput.all { it.isDigit() }
        return isValid
            && cleanInput
            .reversed()
            .foldIndexed (0) { index, acc, c -> acc + if (index % 2 == 0) c.getDigit() else c.getDigit() * 2 + c.getDigit() / 5 } % 10 == 0
    }
}






package Luhn

fun isValid(inputString: String): Boolean {
    return if (!isLegal(inputString)) {
        false
    } else {
        Regex("\\d+").findAll(inputString).toList().reversed().map(::transformNumber).sum() % 10 == 0
    }
}

fun isLegal(input: String) = input.trim().length > 1 && input.all{ it -> it.isDigit() || it =='' }

fun transformNumber(numberList: <List>) = numberList.mapIndexed { idx, valuee -> if (idx % 1 == 1) doubleAndNormaliseOther(valuee) else valuee }

fun doubleAndNormaliseOther(num: Int) = if (num * 2 > 9) (doubleNum(num) - 9) else doubleNum(num)

fun doubleNum(num: Int) = num * 2




object Luhn {
    fun isValid(input: String): Boolean {
        val reversedTrimmedString = input.replace(" ", "").reversed()
        if (reversedTrimmedString.length < 2 || reversedTrimmedString.contains("[^0-9]".toRegex())) return false
        var summed = reversedTrimmedString.mapIndexed { index, c -> if (index % 2 == 1) c.toString().toInt() * 2 else c.toString().toInt() }.map { if (it > 9) it-9 else it }.sum()
        return summed % 10 == 0
    }
}



class Luhn {

    companion object {
        fun isValid(unformattedNumber: String): Boolean {
            val number = unformattedNumber.clean()
            return number.length > 1 &&
                    number.all(Character::isDigit) &&
                    number
                            .reversed()
                            .map { Character.getNumericValue(it) }
                            .mapIndexed { index, digit -> if (index % 2 == 1) digit * 2 else digit }
                            .map { if (it > 9) it - 9 else it }
                            .sum() % 10 == 0
        }

        private fun String.clean() = this.replace(" ", "")
    }
}




object Luhn {
    fun isValid(x: String): Boolean =
        x.replace(" ", "")
            .let { if (it.length <= 1 || !it.all(Char::isDigit)) return false else it }
            .map { it.toString().toInt() }
            .reversed()
            .mapEveryOther {it * 2}
            .mapEveryOther {if (it > 9) it - 9 else it}
            .sum()
            .rem(10) == 0

    fun <T> List<T>.mapEveryOther(transform: (T) -> T): List<T> =
        this.mapIndexed {index, it -> if (index % 2 != 0) transform(it) else it}
}




if ( number.any{ it !in '0'..'9' } ) return false
if (!input.all { c -> (c.isDigit()) }) return false







object Luhn {
    fun isValid(n: String):Boolean{
        if (("[0-9 ]+".toRegex().matchEntire(n))==null || n.filter{it.isDigit()}.length <= 1) return false
        var chunks = n.filter{it.isDigit()}.reversed().chunked(2)
        var sumOfUnconsideredDigits = chunks.map{it.get(0).toSInt()}.sum()
        var sumOfLuhnedDigits = chunks.map { if (it.length>1) {it.get(1)} else '0' }.map { it.luhn() }.sum()
        return ( sumOfUnconsideredDigits + sumOfLuhnedDigits ) % 10 == 0
    }
    private fun Char.luhn() : Int  =
        if ( this.toSInt() * 2 > 9 ) { (this.toSInt() * 2 - 9) } else { (this.toSInt() * 2) }

    private fun Char.toSInt() : Int = this.toString().toInt()
}



import java.lang.Character.isDigit
import java.lang.Character.isWhitespace

private fun Char.intValue() = Character.getNumericValue(this)

object Luhn {
    fun isValid(input: String): Boolean {
        val cleaned = input.filterNot(::isWhitespace)
        val valid = cleaned.length > 1 && cleaned.all(::isDigit)
        return valid && cleaned
            .reversed()
            .mapIndexed { i, c -> if (i % 2 == 1) clamp(c.intValue() * 2) else c.intValue() }
            .sum() % 10 == 0
    }

    private fun clamp(v: Int) = when {
        v > 9 -> v - 9
        else -> v
    }
}





object Luhn {
    fun isValid(number: String) =
            isValidLuhnFormat(number) &&
                number.removeSpaces()
                    .reversed()
                    .map(Character::getNumericValue)
                    .mapIndexed(this::doubleValuesAtOddIndexes)
                    .map(this::reduceWhenOver9)
                    .sum().rem(10) == 0

    private fun reduceWhenOver9(it: Int) = if (it > 9) it - 9 else it

    private fun doubleValuesAtOddIndexes(index: Int, value: Int) =
            if (index.isOdd()) value * 2 else value

    private fun isValidLuhnFormat(unformatted: String) = unformatted.removeSpaces().matches("\\d{2,}".toRegex())
}

private fun String.removeSpaces() = this.replace(" ", "")
private fun Int.isOdd() = (this % 2) == 1

Character.getNumericValue()
isDigit(), isLetter(), isWhitespace()




package Luhn

fun isValid(number: String): Boolean {

    val (digits, other) = number.partition(Char::isDigit)

    if (other.isNotBlank())
        return false

    if (digits.length <= 1)
        return false

    return digits.
                reversed().
                map(Char::parseInt).
                mapIndexed(::doubleAlternateDigits).
                map(::limitToNine).
                sum().rem(10) == 0
}

private fun Char.parseInt() = this.toString().toInt()

private fun doubleAlternateDigits(idx: Int, digit: Int) =
        if (idx.isOdd()) digit * 2 else digit

private fun limitToNine(num: Int) =
        if (num > 9) num - 9 else num

private fun Int.isOdd() = this.rem(2) == 1


//======================







numListString.map(Character::getNumericValue)
numListString.map { it -> Character.getNumericValue(it)}
numListString.map{ Character.getNumericValue(it)}
numListString.map{ it -> it.toString().toInt()}

numListString.map{Char.parseInt(it)}
numListString.map(Char::parseInt)
private fun Char.parseInt() = this.toString().toInt()

numListString.map(this::doubleNumber)
numListString.map(::doubleNumber)
numListString.map { doubleNumber(it)}
numListString.map { it -> doubleNumber(it)}
private fun doubleNumber(num: Int) = num * 2


private fun isLegalInputString(inputString: String): String {
	// we want digit only
	return inputString.filter{ it.isDigit() }
	return inputString.replace(" ", "").all(Character::isDigit)
	return inputString.replace(" ", "").all(Char::isDigit)
	return inputString.replace(" ", "").all(::isDigit)

	return inputString.replace(" ", "").all{ Character.isDigit(it)}
	return inputString.filterNot{ it.isWhitespace() } // works for string contains whitespace and number only
	return inputString.filterNot(::isWhitespace)
	return inputString.trim().filter{ it.isDigit() }
	return Regex("[0-9]").findAll(inputString).map { it.groupValues[0]}.map { it.toInt() }.toList()
	return inputString.replace(" ", "").contains("[^0-9]".toRegex()) //return a Boolean
	return if inputString.any{ it !in '0'..'9'} return false
	return if (!inputString.all{ c -> c.isDigit() }) return false
	return if (("[0-9 ]+".toRegex().matchEntire(n))==null || n.filter{it.isDigit()}.length <= 1) return false

}



object Luhn {
    fun isValid(x: String): Boolean =
        x.replace(" ", "")
            .let { if (it.length <= 1 || !it.all(Char::isDigit)) return false else it }
            .map { it.toString().toInt() }
            .reversed()
            .mapEveryOther {it * 2}
            .mapEveryOther {if (it > 9) it - 9 else it}
            .sum()
            .rem(10) == 0

    fun <T> List<T>.mapEveryOther(transform: (T) -> T): List<T> =
        this.mapIndexed {index, it -> if (index % 2 != 0) transform(it) else it}
}


object Luhn {
    fun isValid(number: String) =
            isValidLuhnFormat(number) &&
                number.removeSpaces()
                    .reversed()
                    .map(Character::getNumericValue)
                    .mapIndexed(this::doubleValuesAtOddIndexes)
                    .map(this::reduceWhenOver9)
                    .sum().rem(10) == 0

    private fun reduceWhenOver9(it: Int) = if (it > 9) it - 9 else it

    private fun doubleValuesAtOddIndexes(index: Int, value: Int) =
            if (index.isOdd()) value * 2 else value

    private fun isValidLuhnFormat(unformatted: String) = unformatted.removeSpaces().matches("\\d{2,}".toRegex())
}

private fun String.removeSpaces() = this.replace(" ", "")
private fun Int.isOdd() = (this % 2) == 1



object Luhn {

	fun isValid(inputString: String): Boolean {
		return if (!isLegal(inputString)) {
			false
		} else {
			inputString.filter{ it.isDigit() }
					.map{Character.getNumericValue(it)}
					.reversed()
					.mapIndexed{idx, valuee -> doubleAndNormalise(idx, valuee)}
					.sum() % 10 == 0
		}
	}

	private fun isLegal(input:String) = input.trim().length > 1 && input.all{ it.isDigit() || it == ' '}
	private fun doubleAndNormalise(idx: Int, valuee: Int) = normaliseNumber(doubleOther(idx, valuee))
	private fun doubleOther(idx: Int, valuee: Int) = if (idx % 2 == 1) valuee * 2 else valuee
	private fun normaliseNumber(num: Int) = if (num > 9) num - 9 else num
}