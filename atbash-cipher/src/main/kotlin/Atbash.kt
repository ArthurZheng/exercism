object Atbash {
//    private val MAPPINGS = (('a'..'z').zip('z'.downTo('a')) + ('0'..'9').zip('0'..'9')).toMap()

    private val aToZ = ('a'..'z')
	private val aToZReversed = aToZ.reversed()
	private val zeroToNine = ('0'..'9')
	private val MAPPINGS = (aToZ.zip(aToZReversed) + zeroToNine.zip(zeroToNine)).toMap()


    fun encode(input: String) =
//            input.toLowerCase().replace("[^a-z0-9]".toRegex(), "")
            input.toLowerCase().filter(Char::isLetterOrDigit)
                .translate()
                .chunked(5)
                .joinToString(" ")

    fun decode(input: String) = input.replace(" ", "").translate()

    private fun String.translate() = this.fold(StringBuilder()) { sb, c -> sb.append(MAPPINGS[c]) }.toString()
}


object Atbash {
	private val MAPPINGS = ((('a'..'z').zip('z'.downTo('a'))) + ('0'..'9').zip('0'..'9')).toMap()

//	private val aToZ = ('a'..'z')
//	private val aToZReversed = aToZ.reversed()
//	private val zeroToNine = ('0'..'9')
//	private val MAPPINGS = (aToZ.zip(aToZReversed) + zeroToNine.zip(zeroToNine)).toMap()

	fun encode(plainText: String): String {
		return plainText.filter(Char::isLetterOrDigit).toLowerCase().transfrom().chunked(5).joinToString(" ")
	}

	fun decode(decypher: String): String {
		return decypher.replace(" ", "").transfrom()
	}

	private fun String.transfrom() = this.fold(StringBuilder()) { sb, c -> sb.append(MAPPINGS[c])}.toString()
}





object Atbash {
    private val MAPPINGS = (('a'..'z').zip('z'.downTo('a')) + ('0'..'9').zip('0'..'9')).toMap()

    fun encode(input: String) =
            input.toLowerCase().replace("[^a-z0-9]".toRegex(), "")
                .translate()
                .chunked(5)
                .joinToString(" ")

    fun decode(input: String) = input.replace(" ", "").translate()

    private fun String.translate() = this.fold(StringBuilder()) { sb, c -> sb.append(MAPPINGS[c]) }.toString()
}






object Atbash {

  fun encode(plain: String): String =
    transfrom(plain)
      .chunked(5) { it.joinToString("") }
      .joinToString(" ")

  fun decode(cipher: String): String =
    transfrom(cipher)
      .joinToString("")

  private fun transfrom(input: String): Iterable<Char> =
    input
      .filter(Char::isLetterOrDigit)
      .map(Char::toLowerCase)
      .map(Atbash::substitute2)

  private val A = 'a'.toInt()
  private val Z = 'z'.toInt()

  private fun substitute2(c: Char): Char =
    c.toInt().let { i -> if (i in (A..Z)) (Z - i + A).toChar() else c }
}




object Atbash {

  fun encode(plain: String): String =
    transfrom(plain)
      .chunked(5) { it.joinToString("") }
      .joinToString(" ")

  fun decode(cipher: String): String =
    transfrom(cipher)
      .joinToString("")

  private fun transfrom(input: String): Iterable<Char> =
    input
      .filter(Char::isLetterOrDigit)
      .map(Char::toLowerCase)
      .map(Atbash::substitute2)

  private fun substitute2(c: Char): Char =
    c.let { i -> if (i in 'a'..'z') ('z' - (i - 'a')) else c }
}








object Atbash {
  val pairs = ('a'..'z').let { it.zip(it.reversed()) } +
      ('0'..'9').let { it.zip(it) }

  fun encode(s: String) =
      s.fold("") { acc, c ->
        acc + (pairs.find { c.toLowerCase() == it.first } ?.second ?: "")
      }.chunked(5).joinToString(" ")

  fun decode(s: String) = s.fold("") { acc, c ->
    if (c.isLetterOrDigit()) acc + pairs.find { c == it.second } ?.first ?: ""
    else acc
  }
}




object Atbash {
    private val encodeMapping = ('a'..'z').zip(('z' downTo 'a')).toMap()
//    private val decodeMapping = ('z' downTo 'a').zip('a'..'z').toMap()
    private val decodeMapping = encodeMapping.entries.associateBy({ it.value }) { it.key } // reverse a Map here, there's no built-in method to reverse a Map.

    fun encode(str: String): String = str.filter { it.isLetterOrDigit() }
        .toLowerCase()
        .map { encodeMapping.getOrDefault(it, it) }
        .joinToString("")
        .chunked(5)
        .joinToString(" ")

    fun decode(str: String): String = str.filter { it.isLetterOrDigit() }
        .map { decodeMapping.getOrDefault(it, it) }
        .joinToString("")
}




object Atbash {
    fun encode(input: String): String {
        return convert(input)
                .chunked(5)
                .joinToString(" ")
    }

    fun decode(input: String): String {
        return convert(input)
    }

    private fun convert(input: String): String {
        return input.toLowerCase().replace(Regex("\\W"), "")
                .map { if (it.isDigit()) it else 'z' - (it - 'a') }
                .joinToString("")
    }

}




object Atbash {
    var alphabet=('a'..'z').toList()

    fun List<Char>.translate(c: Char) = if (c.isLetter())
        this[this.lastIndex - this.indexOf(c.toLowerCase())]
        else c

    fun String.cypher() = this
            .filter{it.isLetterOrDigit()}
            .map{alphabet.translate(it)}
            .joinToString("")

    fun encode(input: String) = input.cypher().chunked(5).joinToString(" ")
    fun decode(input: String) = input.cypher()
}





object Atbash {

    fun encode(input: String): String {
        return input.toLowerCase()
                .filter { it.isLetterOrDigit() }
                .map { it.atbash() }
                .joinToString(separator = "")
                .chunked(5)
                .joinToString(separator = " ")
    }

    fun decode(input: String): String {
        return input.map { it.atbash() }.joinToString(separator="")
    }

    private fun Char.atbash() = when {
        this.isDigit() -> this
        this.isWhitespace() -> ""
        else -> 'z' - (this - 'a')
    }
}




object Atbash {

    private val cipherMap = buildCipherMap()

    fun encode(input: String) = input
                .toLowerCase()
                .mapNotNull { cipherMap[it] }
                .joinToString("")
                .chunked(5)
                .joinToString(" ")

    fun decode(input: String) = input.mapNotNull { cipherMap[it] }.joinToString("")

}

private fun buildCipherMap(): Map<Char, Char> {
    val alphabet = ('a'..'z').joinToString("")
    val numbers = (1..9).joinToString("")
    return (alphabet.zip(alphabet.reversed()) + numbers.zip(numbers)).toMap()
}





package Atbash

fun encode(input: String): String {
    return input.
            filter(Char::isLetterOrDigit).
            toLowerCase().
            map(::substitute).
            joinToString(separator = "").
            chunked(5).
            joinToString(separator = " ")
}

fun decode(input: String): String {
    return input.
            filter(Char::isLetterOrDigit).
            map(::substitute).
            joinToString(separator = "")
}

fun substitute(c: Char) = if (c.isLetter()) 'z' - (c - 'a') else c




object Atbash {
    private val chars = ('a'..'z')
    private val atbash = { str : String ->
        str.mapNotNull {
            when {
                it.isLetter() -> chars.reversed().elementAt(chars.indexOf(it))
                it.isDigit() -> it
                else -> null
            }
        }
    }

    fun encode(plaintext: String) : String {
        return atbash.invoke(plaintext.toLowerCase())
                .chunked(5) { it.joinToString("")}
                .joinToString(" ")
    }

    fun decode(codetext: String) : String {
        return atbash.invoke(codetext).joinToString("")
    }
}


/*
 * Created by chiaki on 18/07/16.
 */
object Atbash {
    val encodeMap =
        "abcdefghijklmnopqrstuvwxyz".zip("zyxwvutsrqponmlkjihgfedcba").associate { it }

    val decodeMap =
        "zyxwvutsrqponmlkjihgfedcba".zip("abcdefghijklmnopqrstuvwxyz").associate { it }

    fun coder(input: String, map: Map<Char, Char>): String {
        return input.fold(StringBuilder(), {builder, item ->
            if (item.isLetterOrDigit()) {
                builder.append(map.getOrElse(item.toLowerCase(), {item}))
            }
            builder
        }).toString()
    }

    fun String.make5Group(): String {
        return this.foldIndexed(StringBuilder(), {idx, builder, item ->
            if (idx % 5 == 0 && idx != 0) {
                builder.append(' ')
            }
            builder.append(item)
            builder
        }).toString()
    }

    fun encode(input: String): String = coder(input, encodeMap).make5Group()

    fun decode(input: String): String = coder(input, decodeMap)
}



class Atbash {

    companion object {

        private val plain  = ('a'..'z').zip('z' downTo 'a').toMap()
        private val cipher = ('z' downTo 'a').zip('a'..'z').toMap()

        fun encode(text : String) : String = text
                                            .asSequence()
                                            .filter {it.isLetterOrDigit()}
                                            .joinToString("")
                                            .toLowerCase()
                                            .map {plain[it] ?: it}
                                            .joinToString("")
                                            .chunked(5) { it }
                                            .joinToString(" ")

        fun decode(text : String) : String = text
                                            .replace(" ", "")
                                            .map {cipher[it] ?: it}
                                            .joinToString("")
    }
}




object  Atbash {
    @JvmStatic
    private val GROUP_SIZE = 5

    @JvmStatic
    private val LETTERS = ('a'..'z').toList()

    @JvmStatic
    private val EMPTY_STRING = ""

    @JvmStatic
    private val SPACE = " "

    fun encode(input : String) = input.toLowerCase()
            .replace(Regex("[^a-z0-9]"), EMPTY_STRING)
            .map(this::transpose)
            .joinToString(EMPTY_STRING)
            .chunked(GROUP_SIZE)
            .joinToString(SPACE)

    fun decode(input : String) : String = input.toLowerCase()
            .map(this::transpose)
            .joinToString(EMPTY_STRING)


    private fun transpose(char : Char) = when {
        char.isDigit() -> char
        char.isLetter() -> LETTERS[LETTERS.size - (LETTERS.indexOf(char) + 1)]
        else -> EMPTY_STRING
    }
}



// Things that I learned
inputString.filter(Character::isLetterOrDigit)
("[^a-z0-9]".toRegex())
inputString.replace(("[^a-z0-9]".toRegex()), "")

val pairs = ('a'..'z').let { it.zip(it.reversed()) } +
      ('0'..'9').let { it.zip(it) }

val pairs2 = (('a'..'z').zip('z'.downTo('a'))) + ('0'..'9').zip('0'..'9').toMap()


val alphabets = ('a'..'z')
val digits = ('0'..'9')
val pairs3 = (alphabets.zip(alphabets.reversed()) + digits.zip(digits)).toMap()


  val pairs = ('a'..'z').let { it.zip(it.reversed()) } +
      ('0'..'9').let { it.zip(it) }


chunked(5) has the same impact as windowed(5, 5, true)
fun substitute(c: Char) = if (c.isLetter()) 'z' - (c - 'a') else c

.map {cipher[it] ?: it}
.map { cipher.getOrDefault(it, it)}











object Atbash {
    val alphabets = ('a'..'z')
    val reversedAlphabets = alphabets.reversed()
    val numbers = ('0'..'9') OR val numbers = (0..9).joinToString("")

    val encodeMap = (alphabets.zip(reversedAlphabets) + numbers.zip(numbers)).toMap()
    val decodeMap = (reversedAlphabets.zip(alphabets) + numbers.zip(numbers)).toMap()

    fun encode(input: String): String {
        return input.filter(Character::isLetterOrDigit).toLowerCase().map{ encodeMap.getOrDefault(it, it)}.joinToString("").chunked(5).joinToString(" ")
    }

    fun decode(input: String): String {
        return input.replace(" ", "").map{ decodeMap.getOrDefault(it, it)}.joinToString("")
    }
}


object Atbash {
    val alphabets = ('a'..'z')
    val reversedAlphabets = alphabets.reversed()
    val numbers = ('0'..'9')
    val zippedNumbers = numbers.zip(numbers)

    val encodeMap = (alphabets.zip(reversedAlphabets) + zippedNumbers).toMap()
    val decodeMap = (reversedAlphabets.zip(alphabets) + zippedNumbers).toMap()

    fun encode(input: String): String {
        return input.filter(Character::isLetterOrDigit).toLowerCase().map{ encodeMap.getOrDefault(it, it)}.joinToString("").chunked(5).joinToString(" ")
    }

    fun decode(input: String): String {
        return input.replace(" ", "").map{ decodeMap.getOrDefault(it, it)}.joinToString("")
    }
}


object Atbash {
    val alphabets = ('a'..'z')
    val reversedAlphabets = alphabets.reversed()
    val numbers = ('0'..'9')
    val zippedNumbers = numbers.zip(numbers)

    val encodeMap = (alphabets.zip(reversedAlphabets) + zippedNumbers).toMap()
    val decodeMap = (reversedAlphabets.zip(alphabets) + zippedNumbers).toMap()

    fun encode(plainText: String): String {
        return plainText.filter(Char::isLetterOrDigit).toLowerCase().map(this::transform).joinToString("").chunked(5).joinToString(" ")
    }

    fun decode(cypher: String): String {
        return cypher.replace(" ", "").map(::transform).joinToString("")
    }

    private fun transform(character: Char) = when{
        character.isLetter() -> 'z' - (character - 'a')
        character.isDigit() -> character
        else -> ""
    }
}


object Atbash {
	private val encodeMapping = ((('a'..'z').zip('z'.downTo('a'))) + ('0'..'9').zip('0'..'9')).toMap()
	private val decodeMapping = (('z'.downTo('a')).zip('a'..'z') + ('0'..'9').zip('0'..'9')).toMap()

	fun encode(input: String): String {
		return input.filter(Char::isLetterOrDigit).toLowerCase().map{ it -> encodeMapping.getOrDefault(it, it)}.joinToString("").chunked(5).joinToString(" ")
		return input.filter(Char::isLetterOrDigit).toLowerCase().map{ it -> encodeMapping[it]}.joinToString("").chunked(5).joinToString(" ")
		return input.filter(Char::isLetterOrDigit).toLowerCase().map{ it -> encodeMapping.get(it) ?: it}.joinToString("").chunked(5).joinToString(" ")
	}

	fun decode(cypher: String): String {
		return cypher.filter(Char::isLetterOrDigit).map{ decodeMapping.get(it) ?: it}.joinToString("")
		return cypher.filter(Char::isLetterOrDigit).map{ decodeMapping.getOrDefault(it, it)}.joinToString("")
		return cypher.filter(Char::isLetterOrDigit).map{ it -> decodeMapping[it]}.joinToString("")
	}
}

