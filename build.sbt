name := "expressions-scala"

version := "0.3"

scalaVersion := "3.0.0"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.0.0",
  "org.scalatest"          %% "scalatest"                % "3.2.9" % Test
)
