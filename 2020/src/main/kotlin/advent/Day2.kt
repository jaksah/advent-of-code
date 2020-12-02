package advent

object Day2 : Puzzle<Int, Int> {

    override fun partA(input: List<String>): Int {
        return parseInput(input)
                .count(PasswordEntry::validPartA)
    }

    override fun partB(input: List<String>): Int {
        return parseInput(input)
                .count(PasswordEntry::validPartB)
    }

    private fun parseInput(input: List<String>): List<PasswordEntry> {
        return input.map { i -> PasswordEntry.fromString(i) ?: error("Unable to parse line $i") }
    }


    data class PasswordEntry(val range: IntRange, val required: Char, val password: String) {
        fun validPartA(): Boolean {
            return password.count { c -> c == required }
                    .let(range::contains)
        }

        fun validPartB(): Boolean {
            return (password.getOrNull(range.first - 1)?.let { c -> c == required } ?: false)
                    .xor(password.getOrNull(range.last - 1)?.let { c -> c == required } ?: false)

        }

        companion object {
            private val pattern = "(\\d+)-(\\d+) (\\w+): (\\w+)".toRegex()
            fun fromString(input: String): PasswordEntry? {
                return pattern.matchEntire(input)
                        ?.let { r ->
                            PasswordEntry(
                                    range = IntRange(
                                            Integer.parseInt(r.groups.get(1)?.value!!),
                                            Integer.parseInt(r.groups.get(2)?.value!!)
                                    ),
                                    required = r.groups.get(3)?.value!!.toCharArray().first(),
                                    password = r.groups.get(4)?.value!!,
                            )
                        }
            }
        }
    }
}
