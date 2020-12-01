package advent

object Day1 : Puzzle<Int, Int> {

    const val addsUpTo = 2020
    const val midway = addsUpTo / 2

    override fun partA(input: List<String>): Int {
        return parseInput(input)
                .let(this::findPair)
                .also { println("Found $it") }
                .let { (i1, i2) -> i1 * i2 }
    }

    override fun partB(input: List<String>): Int {
        return parseInput(input)
                .let(this::findTriplet)
                .also { println("Found $it") }
                .let { (i1, i2, i3) -> i1 * i2 * i3 }
    }

    private fun findPair(input: List<Int>): Pair<Int, Int> {
        fun findPair(source: List<Int>, target: List<Int>): Pair<Int, Int>? {
            return source.flatMap { s -> target.map { Pair(s, it) } }
                    .find { (i1, i2) -> i1 + i2 == addsUpTo }
        }
        val (lower, upper) = input.partition { it < midway }

        return findPair(lower, upper) ?: error("No pair found")
    }

    private fun findTriplet(input: List<Int>): Triple<Int, Int, Int> {
        val sorted = input.sorted()
        fun valuesInRange(i: Int): List<Int> {
            return sorted.filter { it < i }
        }

        return sorted
                .flatMap { i1 ->
                    valuesInRange(i1)
                            .flatMap { i2 ->
                                valuesInRange(i1 + i2)
                                        .map { i3 -> Triple(i1, i2, i3) }
                            }
                }
                .find { (i1, i2, i3) -> i1 + i2 + i3 == addsUpTo }
                ?: error("No triplet found")
    }

    private fun parseInput(input: List<String>): List<Int> {
        return input.map(Integer::valueOf)
    }
}
