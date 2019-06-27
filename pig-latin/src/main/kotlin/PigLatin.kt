package PigLatin

fun translate(inputString: String) = inputString.split(Regex("\\s")).joinToString(" ") { translateWord(it) }

private fun translateWord(str: String): String {
    val startVowelSound = Regex("(?<vowel>[aeiou]|yt|xr)(?<rest>\\w+)")
    val startConsonantSound = Regex("(?<consonant>ch|qu|thr|th|sch|yt|rh|\\wqu|\\w)(?<rest>\\w+)")
    if (startVowelSound.matches(str)) {
         return str + "ay"
    }
    return startConsonantSound.replace(str, "\${rest}\${consonant}ay")
}

==================================================


class PigLatin {
    companion object {
        fun translate(phrase: String) = phrase.split(Regex("\\s")).joinToString(" ") { translateWord(it) }
        private fun translateWord(str: String): String {
            val startVowelSound = Regex("(?<vowel>[aeiou]|yt|xr)(?<rest>\\w+)")
            val startConsonantSound = Regex("(?<consonant>ch|qu|thr|th|sch|yt|rh|\\wqu|\\w)(?<rest>\\w+)")

            if (startVowelSound.matches(str)) {
                return str + "ay"
            }
            return startConsonantSound.replace(str, "\${rest}\${consonant}ay")
        }
    }
}

==================================================


object PigLatin {
    fun translate(input: String): String {
        return input.split(" ").joinToString(" ") {
            val cluster = getCluster(it)
            (if (cluster.isEmpty()) it else it.drop(cluster.length).plus(cluster)).plus("ay")
        }
    }

    private fun getCluster(input: String): String {
        return Regex("^y[aeiouy]").find(input)?.value?.get(0)?.toString() ?: // I do not understand this rule, it is not in the exercise rules
        Regex("^[^aeiouy]*qu+").find(input)?.value ?:
        Regex("^[^xaeiouy]+").find(input)?.value ?:
        Regex("^x[aeiouy]+").find(input)?.value?.get(0)?.toString() ?:
        ""
    }
}

==================================================


class PigLatin {
    companion object {
        fun translate(input: String): String {
            return when {
                input.containsMultipleWords() -> input.forEachWord().map { translate(it) }.joinToString(" ")
                input.startWithVowelSound() -> input + "ay"
                input.startWithThreeConsonantSound() -> input.rotateBy(3) + "ay"
                input.startWithTwoConsonantSound() -> input.rotateBy(2) + "ay"
                input.startWithConsonantSound() -> input.rotateBy(1) + "ay"
                else -> throw IllegalAccessException()
            }
        }
    }
}

private fun String.startWithThreeConsonantSound() = this.startsWith("thr") ||
        this.startsWith("squ") || this.startsWith("sch")

private fun String.startWithTwoConsonantSound() = this.startsWith("ch") ||
        this.startsWith("qu") || this.startsWith("th") || this.startsWith("rh")

private fun String.rotateBy(i: Int) = this.substring(i) + substring(0 until i)

private fun String.forEachWord() = this.split(" ").asSequence()

private fun String.containsMultipleWords() = this.contains(" ")

private fun String.startWithVowelSound() = this.first().isVowel()
        || this.startsWith("yt")
        || this.startsWith("xr")

private fun String.startWithConsonantSound() = !this.first().isVowel()

private fun Char.isVowel() = this in listOf('a', 'e', 'i', 'o', 'u')


============================

class PigLatin {
    companion object {
        fun translate(input: String): String {
            var output: String

            // Uses 2 regular expressions to handle the replacements, obviating need to split up the string and patch
            // it together. Downside is lack of clarity.

            // Regex1 handles the switching on consonants. Breakdown:
            // \b -> only start match at beginning of a word
            // (?!yt|xr) -> do not match if the opening two characters are "yt" or "xr"
            // (?:qu|[bcdfghjklmnpqrstvwxyz]) -> Matches first character if it is a consonant (including "y"). Also
            // match "qu," thus treating the "u" as a consonant but only when preceded by a "q."
            // (?:qu|[bcdfghjklmnpqrstvwxz])* -> Matches any additional consonants (not including "y"
            // The above two groups are treated as one group. Together they make up the "consonant cluster"
            // (\w*) -> grabs the remainder of the word, starting with a vowel
            val regex1 = Regex (
                    """\b(?!yt|xr)((?:qu|[bcdfghjklmnpqrstvwxyz])(?:qu|[bcdfghjklmnpqrstvwxz])*)(\w*)""",
                    RegexOption.IGNORE_CASE)

            // Comparatively simple regex to match whole words in string.
            val regex2 = Regex ("""(\w+)""")

            // Swaps the consonant cluster and the remainder of the word, for words that start with a consonant cluster.
            output = regex1.replace(input, "$2$1")

            // Adds "ay" to each word before returning.
            return regex2.replace(output, "$1ay")
        }
    }
}






