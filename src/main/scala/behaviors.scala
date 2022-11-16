package edu.luc.cs.laufer.cs371.expressions

import Expr.*
import Operator.*

object behaviors:

  def toFunction1(op: Operator): Int => Int = op match
    case Plus => + _
    case Minus => - _

  def toFunction2(op: Operator): (Int, Int) => Int = op match
    case Plus => _ + _
    case Minus => _ - _
    case Times => _ * _
    case Div => _ / _
    case Mod => _ % _

  def evaluate(e: Expr): Int = e match
    case Constant(c) => c
    case Unary(op, e)   => toFunction1(op)(evaluate(e))
    case Binary(l, op, r)  => toFunction2(op)(evaluate(l), evaluate(r))

  def size(e: Expr): Int = e match
    case Constant(_) => 1
    case Unary(_, e) => 1 + size(e)
    case Binary(l, _, r) => 1 + size(l) + size(r)

  def height(e: Expr): Int = e match
    case Constant(_) => 1
    case Unary(_, e) => 1 + height(e)
    case Binary(l, _, r) => 1 + math.max(height(l), height(r))

  import org.json4s.JsonAST.JValue
  import org.json4s.JsonDSL.*
  def toJson(e: Expr): JValue = e match
    case Constant(c) => c
    case Unary(op, e) => ("op" -> op.toString) ~ ("expr" -> toJson(e))
    case Binary(l, op, r) => ("left" -> toJson(l)) ~ ("op" -> op.toString) ~ ("right" -> toJson(r))

end behaviors
