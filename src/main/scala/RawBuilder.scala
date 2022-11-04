package edu.luc.cs.laufer.cs371.expressions

object RawBuilder extends ExprParser[Any]:
  override def onExpr = identity
  override def onTerm = identity
  override def onNumber = identity
  override def onPlusFactor = identity
  override def onMinusFactor = identity
  override def onParenExpr = identity
end RawBuilder
