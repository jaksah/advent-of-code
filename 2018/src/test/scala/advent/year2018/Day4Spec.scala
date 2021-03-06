package advent.year2018

import advent.util._
import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class Day4Spec extends FlatSpec with Matchers {

  val input = Source.fromResource("2018/Day4.txt").getLines().toList

  "Day4" should "solve first part of the puzzle" in {
    val testInput = """
      |[1518-11-01 00:00] Guard #10 begins shift
      |[1518-11-01 00:05] falls asleep
      |[1518-11-01 00:25] wakes up
      |[1518-11-01 00:30] falls asleep
      |[1518-11-01 00:55] wakes up
      |[1518-11-01 23:58] Guard #99 begins shift
      |[1518-11-02 00:40] falls asleep
      |[1518-11-02 00:50] wakes up
      |[1518-11-03 00:05] Guard #10 begins shift
      |[1518-11-03 00:24] falls asleep
      |[1518-11-03 00:29] wakes up
      |[1518-11-04 00:02] Guard #99 begins shift
      |[1518-11-04 00:36] falls asleep
      |[1518-11-04 00:46] wakes up
      |[1518-11-05 00:03] Guard #99 begins shift
      |[1518-11-05 00:45] falls asleep
      |[1518-11-05 00:55] wakes up
    """.stripMargin

    Day4.partA(clean(testInput)) shouldBe 240
    runPuzzle(input)(Day4.partA)
  }

  it should "solve second part of the puzzle" in pending
}