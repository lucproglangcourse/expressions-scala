name := "expressions-scala"

version := "0.3"

scalaVersion := "3.0.0-RC2"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.2.0-RC1",
  "org.scalatest"          %% "scalatest"                % "3.2.7" % Test
)
