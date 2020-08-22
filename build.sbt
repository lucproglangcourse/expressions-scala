name := "expressions-scala"

version := "0.2"

scalaVersion := "2.13.3"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "org.parboiled"          %% "parboiled"                % "2.2.0",
  "org.scalatest"          %% "scalatest"                % "3.2.2" % Test
)
