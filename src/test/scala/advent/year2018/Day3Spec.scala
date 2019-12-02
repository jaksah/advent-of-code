package advent.year2018

import advent.util._
import org.scalatest._

import scala.io.Source

class Day3Spec extends FlatSpec with Matchers {

  val input = Source.fromResource("Day3.txt").getLines().toList

  "Day3" should "solve first part of the puzzle" in {
    val testInput =
      """
        |#1 @ 1,3: 4x4
        |#2 @ 3,1: 4x4
        |#3 @ 5,5: 2x2
      """.stripMargin

    Day3.partA(clean(testInput)) shouldBe 4
    runPuzzle(input)(Day3.partA)
  }

  it should "solve second part of the puzzle" in {
    val testInput =
      """
        |#1 @ 1,3: 4x4
        |#2 @ 3,1: 4x4
        |#3 @ 5,5: 2x2
      """.stripMargin

    Day3.partB(clean(testInput)) shouldBe Some("#3")
    runPuzzle(input)(Day3.partB)
  }
}
