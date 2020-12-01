package advent

import org.junit.Test
import kotlin.test.assertEquals

class Day1Test : PuzzleRunner<Int, Int>() {
    override val input = javaClass.getResourceAsStream("/Day1.txt").bufferedReader().readLines();
    override val puzzle = Day1

    @Test
    fun `Part A example`() {
        val exampleInput = """
            1721
            979
            366
            299
            675
            1456
        """.trimIndent()
        val correctAnswer = 514579
        val actualAnswer = Day1.partA(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }

    @Test
    fun `Part B example`() {
        val exampleInput = """
            1721
            979
            366
            299
            675
            1456
        """.trimIndent()
        val correctAnswer = 241861950
        val actualAnswer = Day1.partB(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }
}