package advent.year2019

import advent.util.runPuzzle
import org.scalatest._

import scala.io.Source

class Day1Spec extends FlatSpec with Matchers {

  val input: List[String] = Source.fromResource("2019/Day1.txt").getLines().toList

  "Day1" should "solve first part of the puzzle" in {
    val examples = Map(
      "12" -> 2,
      "14" -> 2,
      "1969" -> 654,
      "100756" -> 33583,
    )

    examples.foreach { entry => Day1.partA(entry._1 :: Nil) shouldBe entry._2 }
    runPuzzle(input)(Day1.partA)
  }

  it should "solve second part of the puzzle" in {
    val examples = Map(
      "100756" -> 50346
    )

    examples.foreach { entry => Day1.partB(entry._1 :: Nil) shouldBe entry._2 }
    runPuzzle(input)(Day1.partB)
  }
}