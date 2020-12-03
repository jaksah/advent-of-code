package advent

import org.junit.Test
import kotlin.system.measureTimeMillis

abstract class PuzzleRunner<A, B> {
    abstract val input: List<String>
    abstract val puzzle: Puzzle<A, B>

    private val day: String by lazy { puzzle.javaClass.simpleName }

    @Test
    fun `Part A`() {
        measureTimeMillis {
            printHeader("Part A")
                    .let { puzzle.partA(input) }
                    .also(::printResult)
        }.also(::printFooter)
    }

    @Test
    fun `Part B`() {
        measureTimeMillis {
            printHeader("Part B")
                    .let { puzzle.partB(input) }
                    .also(::printResult)
        }.also(::printFooter)
    }

    private fun printHeader(part: String) {
        println("Running Puzzle for $day - $part")
    }

    private fun <T> printResult(result: T) {
        println("Result: $result")
    }

    private fun printFooter(millis: Long) {
        println("Duration: ${millis}ms")
        println()
    }
}