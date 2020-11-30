package advent

trait Puzzle[A, B] {
  def partA(input: List[String]): A
  def partB(input: List[String]): B
}
