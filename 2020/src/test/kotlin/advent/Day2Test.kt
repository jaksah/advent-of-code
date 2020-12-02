package advent

import org.junit.Test
import kotlin.test.assertEquals

class Day2Test : PuzzleRunner<Int, Int>() {
    override val input = javaClass.getResourceAsStream("/Day2.txt").bufferedReader().readLines();
    override val puzzle = Day2

    private val exampleInput = """
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
    """.trimIndent()

    @Test
    fun `Part A example`() {
        val correctAnswer = 2
        val actualAnswer = puzzle.partA(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }

    @Test
    fun `Part B example`() {
        val correctAnswer = 1
        val actualAnswer = puzzle.partB(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }
}