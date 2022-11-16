package edu.luc.cs.laufer.cs371.expressions

import scala.util.Try

object Calculator:

  def processExpr(input: String): Unit =
    println("You entered: " + input)
    val result = ExprParser.parseAll(ExprParser.expr, input)
    if result.isEmpty then
      println("This expression could not be parsed")
    else
      import org.json4s.native.JsonMethods.{pretty, render}
      import behaviors.*
      val cst = result.get
      println("The parse tree (concrete syntax tree) is: " + cst)
      val expr = ASTBuilder(cst)
      println("The resulting abstract syntax tree (AST) is: " + expr)
      println("The corresponding JSON structure is:")
      println(pretty(render(toJson(expr))))
      println("The AST has size " + size(expr) + " and height " + height(expr))
      println("It evaluates to " + Try(evaluate(expr)))

  def main(args: Array[String]): Unit =
    if args.length > 0 then
      processExpr(args mkString " ")
    else
      print("Enter infix expression: ")
      scala.io.Source.stdin.getLines() foreach { line =>
        processExpr(line)
        print("Enter infix expression: ")
      }

end Calculator
