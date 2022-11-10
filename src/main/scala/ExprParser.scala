package edu.luc.cs.laufer.cs371.expressions

import scala.util.parsing.combinator.JavaTokenParsers
import Expr.*

object ExprParser extends JavaTokenParsers:

  /** expr ::= term { { "+" | "-" } term }* */
  def expr: Parser[Any ~ Option[String ~ Any]] = term ~! opt(("+" | "-") ~! term)

  /** term ::= factor { { "*" | "/" | "%" } factor }* */
  def term: Parser[Any ~ Option[String ~ Any]] = factor ~! opt(("*" | "/" | "%") ~! factor)

  /** factor ::= wholeNumber | "+" factor | "-" factor | "(" expr ")" */
  def factor: Parser[Any] = wholeNumber | "+" ~! factor | "-" ~! factor | "(" ~! expr ~! ")"

end ExprParser
