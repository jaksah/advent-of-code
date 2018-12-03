lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.jaksah",
      scalaVersion := "2.12.7",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Advent of Code",
    libraryDependencies ++= dependencies,
    scalacOptions += "-Ypartial-unification"

  )

lazy val dependencies = List(
  "org.typelevel" %% "cats-core" % "1.5.0",
  "org.scalatest" %% "scalatest" % "3.0.5"
)
