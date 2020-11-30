package advent

interface Puzzle<A, B> {
    fun partA(input: List<String>): A
    fun partB(input: List<String>): B
}