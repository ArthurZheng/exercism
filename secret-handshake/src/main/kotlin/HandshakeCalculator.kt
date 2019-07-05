
object HandshakeCalculator {

  fun calculateHandshake(n: Int): List<Signal> =
    if (n >= 16)
      calculateHandshake(n - 16).reversed()
    else if (n >= 8)
      calculateHandshake(n - 8) + listOf(Signal.JUMP)
    else if (n >= 4)
      calculateHandshake(n - 4) + listOf(Signal.CLOSE_YOUR_EYES)
    else if (n >= 2)
       calculateHandshake(n - 2) + listOf(Signal.DOUBLE_BLINK)
    else if (n >= 1)
      listOf(Signal.WINK)
    else
      listOf()

}


object HandshakeCalculator {
    fun calculateHandshake(source: Int): List<Signal> =
            actions.filter { it.first and source == it.first }
                    .map{ it.second }
                    .fold(listOf()) { result, action -> action(result)}

    private val actions = listOf<Pair<Int, (List<Signal>) -> List<Signal>>>(
        1 to { l -> l + Signal.WINK},
        2 to { l -> l + Signal.DOUBLE_BLINK},
        4 to { l -> l + Signal.CLOSE_YOUR_EYES},
        8 to { l -> l + Signal.JUMP },
        16 to { l -> l.reversed() }
    )
}


object HandshakeCalculator {
    fun calculateHandshake(n: Int): List<Signal> {
        val result = mutableListOf<Signal>()

        if (n and 1 != 0) result.add(Signal.WINK)
        if (n and 2 != 0) result.add(Signal.DOUBLE_BLINK)
        if (n and 4 != 0) result.add(Signal.CLOSE_YOUR_EYES)
        if (n and 8 != 0) result.add(Signal.JUMP)
        if (n and 16 != 0) result.reverse()
        return result
    }
}




object HandshakeCalculator {
    fun calculateHandshake(n: Int):List<Signal>{
        val code = mutableListOf<Signal>()
//        val code: MutableList<Signal> = mutableListOf()
        Integer.toBinaryString(n).toList().asReversed().forEachIndexed{ index, char ->
            if (char == '1') when (index) {
                0 -> code.add(Signal.WINK)
                1 -> code.add(Signal.DOUBLE_BLINK)
                2 -> code.add(Signal.CLOSE_YOUR_EYES)
                3 -> code.add(Signal.JUMP)
                4 -> code.reverse()
            }
        }

        return code
    }
}
