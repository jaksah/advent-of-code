package advent

import scala.util.matching.Regex

object Day3 {

  trait EntryTrait {
    val id: String
    val x: Int
    val y: Int
    val width: Int
    val height: Int
  }
  case class Entry(id: String, x: Int, y: Int, width: Int, height: Int) extends EntryTrait
  case class UnitEntry(id: String, x: Int, y: Int) extends EntryTrait {
    val width: Int = 1
    val height: Int = 1
  }

  // (id) @ (x),(y): (h)x(w)
  val entryPattern: Regex =
    """(#\d+) @ (\d+),(\d+): (\d+)x(\d+)""".r

  def parser(input: String): Option[Entry] =
    input match {
      case entryPattern(id, x, y, w, h) =>
        Some(Entry(id, x.toInt, y.toInt, w.toInt, h.toInt))
      case _ =>
        println(s"Invalid entry: $input")
        None
    }

  def partA(input: List[String]): Int = {

    def explode(entry: Entry): Set[UnitEntry] = {
      def loop(xIdx: Int, yIdx: Int): Set[UnitEntry] =
        (xIdx, yIdx) match {
          case (_, entry.height) =>
            Set.empty
          case (entry.width, _) =>
            loop(0, yIdx + 1)
          case (_, _) =>
            loop(xIdx + 1, yIdx) + UnitEntry(entry.id, entry.x + xIdx, entry.y + yIdx)
        }

      loop(0, 0)
    }

    input
      .flatMap(parser)
      .map(explode)
      .flatMap(_.toList)
      .groupBy(entry => s"${entry.x}|${entry.y}")
      .count { case (_, entries) => entries.size > 1 }
  }

  def partB(input: List[String]): Int =
    ???

}
