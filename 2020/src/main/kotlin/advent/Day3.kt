package advent

object Day3 : Puzzle<Long, Long> {

    override fun partA(input: List<String>): Long {
        return traverse(parseInput(input), 3, 1).treeCount
    }

    override fun partB(input: List<String>): Long {
        val a = traverse(parseInput(input), 1, 1).treeCount
        val b = traverse(parseInput(input), 3, 1).treeCount
        val c = traverse(parseInput(input), 5, 1).treeCount
        val d = traverse(parseInput(input), 7, 1).treeCount
        val e = traverse(parseInput(input), 1, 2).treeCount
        return a * b * c * d * e
    }

    private fun traverse(grid: Grid, xStep: Int, yStep: Int): Grid {
        var (x, y) = Pair(0, 0)
        do {
            x += xStep
            y += yStep
        } while (grid.visit(x, y))
        return grid
    }

    private fun parseInput(input: List<String>): Grid {
        return input
                .map { s -> s.toCharArray() }
                .toTypedArray()
                .map { charArray -> charArray.map { c -> GridEntity.of(c) ?: error("Can't understand $c") } }
                .let { arr -> Grid(arr) }
    }

    enum class GridEntity(val char: Char) {
        TREE('#'),
        OPEN('.');

        companion object {
            fun of(char: Char): GridEntity? {
                return values().find { e -> e.char == char }
            }
        }
    }

    class Grid(val grid: List<List<GridEntity>>) {
        var treeCount: Long = 0
        var spaceCount: Long = 0

        private val patternWidth = grid.first().size

        private fun entityAt(x: Int, y: Int): GridEntity? {
            return grid.getOrNull(y)?.get(x % patternWidth)
        }

        fun visit(x: Int, y: Int): Boolean {
            return when (entityAt(x, y)) {
                GridEntity.TREE -> {
                    treeCount++
                    true
                }
                GridEntity.OPEN -> {
                    spaceCount++
                    true
                }
                else -> false
            }
        }

    }
}
