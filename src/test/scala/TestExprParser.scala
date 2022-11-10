package edu.luc.cs.laufer.cs371.expressions

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

object MainExprParser:
  def main(args: Array[String]): Unit =
    val raw = ExprParser.parseAll(ExprParser.expr, complex1string)
    val ir = IRBuilder(raw)
    println(raw)
    println(ir)
    println(complex1)
    println(ir == complex1)
    println(behaviors.evaluate(ir))
end MainExprParser

class TestExprParser extends AnyFunSuite:
  val raw1 = ExprParser.parseAll(ExprParser.expr, complex1string)
  val raw2 = ExprParser.parseAll(ExprParser.expr, complex1string2)
  test("parser works 1") { assert(IRBuilder(raw1.get) == complex1) }
  test("parser works 2") { assert(IRBuilder(raw2.get) == complex1) }
end TestExprParser
