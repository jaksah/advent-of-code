package advent.year2019

import advent.Puzzle

import scala.annotation.tailrec

object Day1 extends Puzzle[Int, Int] {

  def calculateFuel(mass: Int): Int =
    math.max(0, mass / 3 - 2)


  def calculateFuelRec(mass: Int): Int = {
    @tailrec
    def loop(tot: Int, mass: Int): Int = mass match {
      case m if m <= 0 => tot
      case m =>
        val fuelMass = calculateFuel(m)
        loop(tot + fuelMass, fuelMass)
    }
    loop(0, mass)
  }

  def partA(input: List[String]): Int =
    input
      .map(_.toInt)
      .map(calculateFuel)
      .sum


  def partB(input: List[String]): Int =
    input
      .map(_.toInt)
      .map(calculateFuelRec)
      .sum

}
