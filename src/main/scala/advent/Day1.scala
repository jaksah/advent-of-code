package advent

import scala.annotation.tailrec

object Day1 extends Puzzle[Int, Int] {
  private def asInt(freq: String): Int = freq.toList match {
    case '+' :: xs => new String(xs.toArray).toInt
    case '-' :: xs => -new String(xs.toArray).toInt
    case _ :: xs => 0
    case Nil => 0
  }

  def partA(input: List[String]): Int =
    input
      .map(asInt)
      .sum

  def partB(input: List[String]): Int = {
    val inputInts = input.map(asInt)

    @tailrec
    def loop(agg: Int, list: List[Int], memory: Set[Int]): Int =
      list match {
        case i :: _ if memory.contains(agg + i) =>
          //println(s"End $agg, $i, ${agg+i}, mem: ${memory.reverse}")
          agg + i
        case i :: is =>
          //println(s"Loop $agg, $i, ${agg+1}, mem: ${memory.reverse}")
          loop(agg + i, is, memory + (agg + i))
        case Nil =>
          //println(s"Repeat $agg, mem: ${memory.reverse}")
          loop(agg, inputInts, memory)
      }

    loop(0, inputInts, Set(0))
  }

}
