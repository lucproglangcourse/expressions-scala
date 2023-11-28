package edu.luc.cs.laufer.cs371.expressions

import util.Try

import Expr.*

object behaviors:

  private def evaluateR(e: Expr): Int = e match
    case Constant(c) => c
    case UMinus(r)   => -evaluateR(r)
    case Plus(l, r)  => evaluateR(l) + evaluateR(r)
    case Minus(l, r) => evaluateR(l) - evaluateR(r)
    case Times(l, r) => evaluateR(l) * evaluateR(r)
    case Div(l, r)   => evaluateR(l) / evaluateR(r)
    case Mod(l, r)   => evaluateR(l) % evaluateR(r)

  def evaluate(e: Expr): Try[Int] = Try(evaluateR(e))

  def size(e: Expr): Int = e match
    case Constant(c) => 1
    case UMinus(r)   => 1 + size(r)
    case Plus(l, r)  => 1 + size(l) + size(r)
    case Minus(l, r) => 1 + size(l) + size(r)
    case Times(l, r) => 1 + size(l) + size(r)
    case Div(l, r)   => 1 + size(l) + size(r)
    case Mod(l, r)   => 1 + size(l) + size(r)

  def height(e: Expr): Int = e match
    case Constant(c) => 1
    case UMinus(r)   => 1 + height(r)
    case Plus(l, r)  => 1 + math.max(height(l), height(r))
    case Minus(l, r) => 1 + math.max(height(l), height(r))
    case Times(l, r) => 1 + math.max(height(l), height(r))
    case Div(l, r)   => 1 + math.max(height(l), height(r))
    case Mod(l, r)   => 1 + math.max(height(l), height(r))

  import org.json4s.JsonAST.JValue
  import org.json4s.JsonDSL.*
  def toJson(e: Expr): JValue = e match
    case Constant(c) => c
    case UMinus(r)   => e.productPrefix -> toJson(r)
    case p           => p.productPrefix -> (0 until p.productArity).map(i => toJson(p.productElement(i).asInstanceOf[Expr]))

end behaviors
