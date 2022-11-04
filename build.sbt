name := "expressions-scala"

version := "0.4"

scalaVersion := "3.2.0"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Yexplicit-nulls", "-Ysafe-init", "-language:strictEquality")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",
  "org.json4s"             %% "json4s-native"            % "4.1.0-M2",
  "org.scalatest"          %% "scalatest"                % "3.2.14" % Test
)

enablePlugins(JavaAppPackaging)
