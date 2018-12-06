package advent

import scala.util.matching.Regex

object Day3 extends Puzzle[Int, Option[String]] {

  case class Pixel(x: Int, y: Int)

  case class Claim(id: String, x: Int, y: Int, width: Int, height: Int) {
    lazy val pixels: List[Pixel] = {
      def loop(xIdx: Int, yIdx: Int): Set[Pixel] =
        (xIdx, yIdx) match {
          case (_, `height`) =>
            Set.empty
          case (`width`, _) =>
            loop(0, yIdx + 1)
          case (_, _) =>
            loop(xIdx + 1, yIdx) + Pixel(x + xIdx, y + yIdx)
        }

      loop(0, 0).toList
    }
  }

  val entryPattern: Regex =
    """(#\d+) @ (\d+),(\d+): (\d+)x(\d+)""".r

  def parser(input: String): Option[Claim] =
    input match {
      case entryPattern(id, x, y, w, h) =>
        Some(Claim(id, x.toInt, y.toInt, w.toInt, h.toInt))
      case _ =>
        println(s"Invalid entry: $input")
        None
    }

  def partA(input: List[String]): Int = {
    input
      .flatMap(parser)
      .flatMap(_.pixels)
      .groupBy(identity)
      .count { case (_, entries) => entries.size > 1 }
  }

  def partB(input: List[String]): Option[String] = {
    val claims = input
      .flatMap(parser)
    val pixels = claims
      .flatMap(_.pixels)
    // TODO: Optimize performance on this
    claims
      .find(claim => (pixels diff claim.pixels intersect claim.pixels).isEmpty)
      .map(_.id)
  }

}
