package edu.luc.cs.laufer.cs371.expressions

import Expr.*

object ASTBuilder:

  given CanEqual[None.type, Any] = CanEqual.derived
  given CanEqual[String, Any] = CanEqual.derived

  import ExprParser.~

  def apply(cst: Any): Expr = cst match
    case "(" ~ e ~ ")" => apply(e)
    case l ~ None => apply(l)
    case l ~ Some((op: String) ~ r) => Binary(apply(l), Operator.fromSymbol(op), apply(r))
    case (op: String) ~ e => Unary(Operator.fromSymbol(op), apply(e))
    case n: String => Constant(n.toInt)

end ASTBuilder
