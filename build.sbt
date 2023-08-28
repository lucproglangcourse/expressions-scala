name := "expressions-scala"

version := "0.4"

scalaVersion := "3.2.0"

scalacOptions += "@.scalacOptions.txt"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0",
  "org.json4s"             %% "json4s-native"            % "4.1.0-M3",
  "org.scalatest"          %% "scalatest"                % "3.2.16" % Test
)

enablePlugins(JavaAppPackaging)
