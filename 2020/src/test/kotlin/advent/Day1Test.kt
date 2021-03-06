package advent

import org.junit.Test
import kotlin.test.assertEquals

class Day1Test : PuzzleRunner<Int, Int>() {
    override val input = javaClass.getResourceAsStream("/Day1.txt").bufferedReader().readLines();
    override val puzzle = Day1

    private val exampleInput = """
        1721
        979
        366
        299
        675
        1456
    """.trimIndent()

    @Test
    fun `Part A example`() {
        val correctAnswer = 514579
        val actualAnswer = puzzle.partA(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }

    @Test
    fun `Part B example`() {
        val correctAnswer = 241861950
        val actualAnswer = puzzle.partB(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }
}