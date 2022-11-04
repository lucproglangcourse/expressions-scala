package edu.luc.cs.laufer.cs371.expressions

import scala.util.parsing.combinator.JavaTokenParsers
import Expr.*

trait ExprParser[Result] extends JavaTokenParsers:

  /**
   * Enable missing typesafe equality for `~`.
   * TODO remove once the combinator parser library provides this.
   */
  given [A, B](using CanEqual[A, A], CanEqual[B, B]): CanEqual[A ~ B, A ~ B] = CanEqual.derived

  /** expr ::= term { { "+" | "-" } term }* */
  def expr: Parser[Result] = term ~! opt(("+" | "-") ~ term) ^^ onExpr

  /** term ::= factor { { "*" | "/" | "%" } factor }* */
  def term: Parser[Result] = factor ~! opt(("*" | "/" | "%") ~ factor) ^^ onTerm

  /** factor ::= wholeNumber | "+" factor | "-" factor | "(" expr ")" */
  def factor: Parser[Result] = 
    wholeNumber ^^ onNumber
    | "+" ~> factor ^^ onPlusFactor
    | "-" ~> factor ^^ onMinusFactor
    | "(" ~> expr <~ ")" ^^ onParenExpr

  def onExpr: Result ~ Option[String ~ Result] => Result
  def onTerm: Result ~ Option[String ~ Result] => Result
  def onNumber: String => Result
  def onPlusFactor: Result => Result
  def onMinusFactor: Result => Result
  def onParenExpr: Result => Result
  
end ExprParser
