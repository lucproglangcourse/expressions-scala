package edu.luc.cs.laufer.cs371.expressions

import scala.util.parsing.combinator.JavaTokenParsers
import ast.Expr, Expr._

object CombinatorParser extends JavaTokenParsers {

  /** Enable typesafe equality between `None` and `Option`. */
  given CanEqual[None.type, Option[_]] = CanEqual.derived

  /** expr ::= term { { "+" | "-" } term }* */
  def expr: Parser[Expr] =
    term ~! opt(("+" | "-") ~ term) ^^ {
      case l ~ None          => l
      case l ~ Some("+" ~ r) => Plus(l, r)
      case l ~ Some("-" ~ r) => Minus(l, r)
    }

  /** term ::= factor { { "*" | "/" | "%" } factor }* */
  def term: Parser[Expr] =
    factor ~! opt(("*" | "/" | "%") ~ factor) ^^ {
      case l ~ None          => l
      case l ~ Some("*" ~ r) => Times(l, r)
      case l ~ Some("/" ~ r) => Div(l, r)
      case l ~ Some("%" ~ r) => Mod(l, r)
    }

  /** factor ::= wholeNumber | "+" factor | "-" factor | "(" expr ")" */
  def factor: Parser[Expr] = (
    wholeNumber ^^ { case s => Constant(s.toInt) }
    | "+" ~> factor ^^ { case e => e }
    | "-" ~> factor ^^ { case e => UMinus(e) }
    | "(" ~ expr ~ ")" ^^ { case _ ~ e ~ _ => e }
  )
}
