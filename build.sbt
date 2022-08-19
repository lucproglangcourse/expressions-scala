name := "expressions-scala"

version := "0.4"

scalaVersion := "3.1.3"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Yexplicit-nulls", "-language:strictEquality")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",
  "org.scalatest"          %% "scalatest"                % "3.2.13" % Test
)

enablePlugins(JavaAppPackaging)

scalacOptions ++= Seq("-rewrite", "-new-syntax")
