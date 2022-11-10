package edu.luc.cs.laufer.cs371.expressions

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

object MainExprParser:
  def main(args: Array[String]): Unit =
    val cst = ExprParser.parseAll(ExprParser.expr, complex1string)
    val ast = ASTBuilder(cst)
    println(cst)
    println(ast)
    println(complex1)
    println(ast == complex1)
    println(behaviors.evaluate(ast))
end MainExprParser

class TestExprParser extends AnyFunSuite:
  val cst1 = ExprParser.parseAll(ExprParser.expr, complex1string)
  val cst2 = ExprParser.parseAll(ExprParser.expr, complex1string2)
  test("parser works 1") { assert(ASTBuilder(cst1.get) == complex1) }
  test("parser works 2") { assert(ASTBuilder(cst2.get) == complex1) }
end TestExprParser
