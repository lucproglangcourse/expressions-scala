package edu.luc.cs.laufer.cs473.expressions

import org.scalatest.funsuite.AnyFunSuite

import behaviors._
import TestFixtures._

object Main extends App {
  println("p = " + complex1)
  println("evaluate(p) = " + evaluate(complex1))
  println("size(p) = " + size(complex1))
  println("height(p) = " + height(complex1))
  println(toFormattedString(complex1))
  println("q = " + complex2)
  println("evaluate(q) = " + evaluate(complex2))
  println("size(q) = " + size(complex2))
  println("height(q) = " + height(complex2))
  println(toFormattedString(complex2))
}

class Test extends AnyFunSuite {
  test("evaluate(p)") { assert(evaluate(complex1) === -1) }
  test("size(p)") { assert(size(complex1) === 9) }
  test("height(p)") { assert(height(complex1) === 4) }
  test("evaluate(q)") { assert(evaluate(complex2) === 0) }
  test("size(q)") { assert(size(complex2) === 10) }
  test("height(q)") { assert(height(complex2) === 5) }
}
