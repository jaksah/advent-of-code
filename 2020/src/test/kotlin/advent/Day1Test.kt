package advent

class Day1Test : PuzzleRunner<Int, Int>() {
    override val input = javaClass.getResourceAsStream("/Day1.txt").bufferedReader().readLines();
    override val puzzle = Day1
}