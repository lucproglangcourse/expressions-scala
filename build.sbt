name := "expressions-scala"

version := "0.2"

scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1",
  "org.parboiled"          %% "parboiled"                % "2.1.4",
  "org.scalatest"          %% "scalatest"                % "3.0.5" % Test
)
