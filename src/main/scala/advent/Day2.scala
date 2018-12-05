package advent

object Day2 {

  /**
    * Create a checksum of the list
    *
    * @param input
    */
  def partA(input: List[String]): Int = {
    val (doubles, triples) = input
      .map(_.groupBy(identity).mapValues(_.length).values.toSet)
      .map(charFreq =>
        (
          if (charFreq.contains(2)) 1 else 0,
          if (charFreq.contains(3)) 1 else 0
        )
      ).unzip

    doubles.sum * triples.sum
  }

  def partB(input: List[String]): Int =
    ???

}
