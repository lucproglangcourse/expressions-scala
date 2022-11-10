package edu.luc.cs.laufer.cs371.expressions

/** An initial algebra of arithmetic expressions. */
enum Expr derives CanEqual:
  case Constant(value: Int)
  case Unary(op: Operator, expr: Expr)
  case Binary(left: Expr, op: Operator, right: Expr)

enum Operator derives CanEqual:
  case Plus, Minus, Times, Div, Mod

object Operator:
  def fromSymbol(symbol: String): Operator = symbol match
    case "+" => Plus
    case "-" => Minus
    case "*" => Times
    case "/" => Div
    case "%" => Mod
