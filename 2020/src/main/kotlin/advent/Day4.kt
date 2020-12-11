package advent

object Day4 : Puzzle<Int, Int> {

    override fun partA(input: List<String>): Int {
        return parseInput(input, PassportEntry::parsePartA)
                .count { pe -> pe is PassportEntry.Passport }
    }

    override fun partB(input: List<String>): Int {
        return parseInput(input, PassportEntry::parsePartB)
                .count { pe -> pe is PassportEntry.Passport }
    }

    private fun parseInput(input: List<String>, parser: (Map<String, String>) -> PassportEntry): List<PassportEntry> {
        return input.foldIndexed(Pair(emptyList<String>(), ""), { i, (result, prev), line ->
            when {
                line.isBlank() -> Pair(result.plus(prev.trim()), "")
                input.size == i + 1 -> Pair(result.plus("${prev.trim()} ${line.trim()}"), "")
                else -> Pair(result, "${prev.trim()} ${line.trim()}")
            }
        })
                .first
                .map {
                    it.split("\\s".toRegex())
                            .filter { it.isNotBlank() }
                            .map { passportKeyPair ->
                                val parts = passportKeyPair.split(":")
                                Pair(parts.get(0), parts.get(1))
                            }
                            .toMap()
                            .let { map -> parser(map) }
                }
    }

    sealed class PassportEntry {
        object InvalidPassport : PassportEntry()
        data class Passport(
                val byr: String, // (Birth Year)
                val iyr: String, // (Issue Year)
                val eyr: String, // (Expiration Year)
                val hgt: String, // (Height)
                val hcl: String, // (Hair Color)
                val ecl: String, // (Eye Color)
                val pid: String, // (Passport ID)
                val cid: String?, // (Country ID)
        ) : PassportEntry()

        companion object {
            fun parsePartA(attr: Map<String, String>): PassportEntry {
                return try {
                    Passport(
                            byr = attr["byr"]!!,
                            iyr = attr["iyr"]!!,
                            eyr = attr["eyr"]!!,
                            hgt = attr["hgt"]!!,
                            hcl = attr["hcl"]!!,
                            ecl = attr["ecl"]!!,
                            pid = attr["pid"]!!,
                            cid = attr["cid"],
                    )
                } catch (e: Exception) {
                    InvalidPassport
                }
            }

            /**
            byr (Birth Year) - four digits; at least 1920 and at most 2002.
            iyr (Issue Year) - four digits; at least 2010 and at most 2020.
            eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
            hgt (Height) - a number followed by either cm or in:
            - If cm, the number must be at least 150 and at most 193.
            - If in, the number must be at least 59 and at most 76.
            hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
            ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
            pid (Passport ID) - a nine-digit number, including leading zeroes.
            cid (Country ID) - ignored, missing or not.
             */
            fun parsePartB(attr: Map<String, String>): PassportEntry {
                return try {
                    Passport(
                            byr = attr["byr"]?.takeIf { (1920..2002).contains(it.toInt()) }!!,
                            iyr = attr["iyr"]?.takeIf { (2010..2020).contains(it.toInt()) }!!,
                            eyr = attr["eyr"]?.takeIf { (2020..2030).contains(it.toInt()) }!!,
                            hgt = attr["hgt"]?.takeIf { hgt ->
                                "(\\d{2,3})(cm|in)".toRegex().matchEntire(hgt)?.groups
                                        ?.let { groups ->
                                            if (groups[2]?.value == "cm") {
                                                (150..193).contains(groups[1]?.value?.toInt())
                                            } else {
                                                (59..76).contains(groups[1]?.value?.toInt())
                                            }
                                        } ?: false
                            }!!,
                            hcl = attr["hcl"]?.takeIf { "#[0-9a-f]{6}".toRegex().matches(it) }!!,
                            ecl = attr["ecl"]?.takeIf { setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(it) }!!,
                            pid = attr["pid"]?.takeIf { "\\d{9}".toRegex().matches(it) }!!,
                            cid = attr["cid"],
                    )
                } catch (e: Exception) {
                    InvalidPassport
                }
            }
        }
    }
}
