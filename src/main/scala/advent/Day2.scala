package advent

import scala.annotation.tailrec

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

  def partB(input: List[String]): Option[String] = {
    def ngramsIsh(inputStr: String, n: Int): List[String] = {
      /**
        * Collect the "ngrams" in a Set to prevent duplicate "ngrams" from a single string
        */
      @tailrec
      def loop(str: String, idx: Int, result: Set[String]): List[String] = {
        if (idx >= str.length) {
          result.toList
        } else {
          val gram = str.take(idx) + str.drop(idx + str.length - n)
          loop(str, idx + 1, result + gram)
        }
      }
      loop(inputStr, 0, Set.empty)
    }

    input
      .flatMap(str => ngramsIsh(str, str.length - 1))
      .groupBy(identity)
      .mapValues(_.size)
      .find { case (_, count) => count == 2 }
      .map(_._1)
  }

}
