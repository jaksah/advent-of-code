package advent

import org.junit.Test
import kotlin.test.assertEquals

class Day3Test : PuzzleRunner<Long, Long>() {
    override val input = javaClass.getResourceAsStream("/Day3.txt").bufferedReader().readLines();
    override val puzzle = Day3

    private val exampleInput = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent()

    @Test
    fun `Part A example`() {
        val correctAnswer = 7L
        val actualAnswer = puzzle.partA(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }

    @Test
    fun `Part B example`() {
        val correctAnswer = 336L
        val actualAnswer = puzzle.partB(exampleInput.lines())
        assertEquals(correctAnswer, actualAnswer)
    }
}