package advent

import org.scalatest._
import util._

import scala.io.Source

class Day2Spec extends FlatSpec with Matchers {

  val input: List[String] = Source.fromResource("Day2.txt").getLines().toList

  "Day2" should "solve first part of the puzzle" in {
    val testInput = """
      |abcdef
      |bababc
      |abbcde
      |abcccd
      |aabcdd
      |abcdee
      |ababab
    """.stripMargin

    Day2.partA(clean(testInput)) shouldBe 12
    runPuzzle(input)(Day2.partA)
  }

  it should "solve second part of the puzzle" in {
    val testInput =
      """
        |abcde
        |fghij
        |klmno
        |pqrst
        |fguij
        |axcye
        |wvxyz
      """.stripMargin
    Day2.partB(clean(testInput)) shouldBe Some("fgij")
    runPuzzle(input)(Day2.partB)
  }
}