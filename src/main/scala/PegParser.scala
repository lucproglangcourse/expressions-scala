package edu.luc.cs.laufer.cs371.expressions

import org.parboiled2._
import ast._

class PegParser(val input: ParserInput) extends Parser {

  def InputLine = rule { WhiteSpace ~ Expression ~ EOI }

  /** expression ::= term { { "+" | "-" } term }* */
  def Expression = rule {
    Term ~ zeroOrMore(
      ws('+') ~ Term ~> (Plus(_: Expr, _))
        | ws('-') ~ Term ~> (Minus(_: Expr, _))
    )
  }

  /** term ::= factor { { "*" | "/" | "%" } factor }* */
  def Term = rule {
    Factor ~ zeroOrMore(
      ws('*') ~ Factor ~> (Times(_: Expr, _))
        | ws('/') ~ Factor ~> (Div(_: Expr, _))
        | ws('%') ~ Factor ~> (Mod(_: Expr, _))
    )
  }

  /** factor ::= number | "+" factor | "-" factor | "(" expression ")" */
  def Factor: Rule1[Expr] = rule { Number | UnaryPlus | UnaryMinus | Parens }

  // explicitly handle trailing whitespace
  def Number = rule { capture(Digits) ~ WhiteSpace ~> ((s: String) => Constant(s.toInt)) }

  def UnaryPlus = rule { ws('+') ~ Factor }

  def UnaryMinus = rule { ws('-') ~ Factor ~> (UMinus(_: Expr)) }

  def Parens = rule { ws('(') ~ Expression ~ ws(')') }

  def Digits = rule { oneOrMore(CharPredicate.Digit) }

  val WhiteSpaceChar = CharPredicate(" \n\r\t\f")

  def WhiteSpace = rule { zeroOrMore(WhiteSpaceChar) }

  def ws(c: Char) = rule { c ~ WhiteSpace }
}
