package edu.luc.cs.laufer.cs371.expressions

import util.{ Success, Failure }
import org.scalatest.funsuite.AnyFunSuite

import behaviors.*
import TestFixtures.*

object Main:
  def main(args: Array[String]): Unit =
    process("p", complex1)
    process("q", complex2)
    process("f", bad)

  def process(n: String, e: Expr): Unit =
    println(s"$n = $e")
    println(s"evaluate($n) = ${evaluate(e)}")
    println(s"size($n) = ${size(e)}")
    println(s"height($n) = ${height(e)}")

end Main

class Test extends AnyFunSuite:
  test("evaluate(p)") { assert(evaluate(complex1).get == -1) }
  test("size(p)") { assert(size(complex1) == 9) }
  test("height(p)") { assert(height(complex1) == 4) }
  test("evaluate(q)") { assert(evaluate(complex2).get == 0) }
  test("size(q)") { assert(size(complex2) == 10) }
  test("height(q)") { assert(height(complex2) == 5) }
  test("evaluate(bad)") { assert(evaluate(bad).isFailure) }
end Test
