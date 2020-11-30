package advent

import org.junit.Test

abstract class PuzzleRunner<A, B> {
    abstract val input: List<String>
    abstract val puzzle: Puzzle<A, B>

    private val day: String by lazy { puzzle.javaClass.simpleName }

    @Test
    fun `Part A`() {
        printHeader("Part A")
                .let { puzzle.partA(input) }
                .also(this::printResult)
    }

    @Test
    fun `Part B`() {
        printHeader("Part B")
                .let { puzzle.partB(input) }
                .also(this::printResult)
    }

    private fun <T> printResult(result: T) {
        println("############### RESULT ###############")
        println(result)
        println("######################################")
        println("")
    }

    private fun printHeader(part: String) {
        println("######################################")
        println("## Running Puzzle for $day - $part ##")
    }
}