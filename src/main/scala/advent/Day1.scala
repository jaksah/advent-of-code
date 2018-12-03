package advent

object Day1 {
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

  def partB(input: List[String]): Int =
    input
      .map(asInt)
      .sum

}
