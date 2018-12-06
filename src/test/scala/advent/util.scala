package advent

object util {
  def runPuzzle[A, B](arg: A)(program: A => B): Unit = {
    println("Executing puzzle")
    println(s"Result: ${program(arg)}")
  }

  def clean(input: String): List[String] =
    input.trim.split("\n").toList
}
