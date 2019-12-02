package advent.year2018

import advent.util.runPuzzle
import org.scalatest._

import scala.io.Source

class Day1Spec extends FlatSpec with Matchers {

  val input: List[String] = Source.fromResource("2018/Day1.txt").getLines().toList

  "Day1" should "solve first part of the puzzle" in {
    Day1.partA(List("+1", "+1", "+1")) shouldBe 3
    Day1.partA(List("+1", "+1", "-2")) shouldBe 0
    Day1.partA(List("-1", "-2", "-3")) shouldBe -6
    runPuzzle(input)(Day1.partA)
  }

  it should "solve second part of the puzzle" in {
    Day1.partB(List("+1", "-1")) shouldBe 0
    Day1.partB(List("+3", "+3", "+4", "-2", "-4")) shouldBe 10
    Day1.partB(List("-6", "+3", "+8", "+5", "-6")) shouldBe 5
    Day1.partB(List("+7", "+7", "-2", "-7", "-4")) shouldBe 14
    runPuzzle(input)(Day1.partB)
  }
}