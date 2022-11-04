package edu.luc.cs.laufer.cs371.expressions

import Expr.*

object ASTBuilder extends ExprParser[Expr]:

  override def onExpr: Expr ~ Option[String ~ Expr] => Expr =
    case l ~ None => l
    case l ~ Some("+" ~ r) => Plus(l, r)
    case l ~ Some("-" ~ r) => Minus(l, r)

  override def onTerm: Expr ~ Option[String ~ Expr] => Expr =
    case l ~ None => l
    case l ~ Some("*" ~ r) => Times(l, r)
    case l ~ Some("/" ~ r) => Div(l, r)
    case l ~ Some("%" ~ r) => Mod(l, r)

  override def onNumber = Constant.apply compose (_.toInt)

  override def onPlusFactor = identity

  override def onMinusFactor = UMinus.apply

  override def onParenExpr = identity

end ASTBuilder
