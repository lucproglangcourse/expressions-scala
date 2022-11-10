package edu.luc.cs.laufer.cs371.expressions

import Expr.*

import scala.util.parsing.combinator.Parsers

object IRBuilder:

  given CanEqual[None.type, Any] = CanEqual.derived

  import ExprParser.~

  def apply(raw: Any): Expr = raw match
    case l ~ None => apply(l)
    case l ~ Some((op: String) ~ r) => Binary(apply(l), Operator.fromSymbol(op), apply(r))
    case (op: String) ~ e => Unary(Operator.fromSymbol(op), apply(e))
    case n: String => Constant(n.toInt)

end IRBuilder
