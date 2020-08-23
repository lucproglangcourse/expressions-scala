package edu.luc.cs.laufer.cs473.expressions

object CombinatorCalculator extends App {

  def processExpr(input: String): Unit = {
    println("You entered: " + input)
    val result = CombinatorParser.parseAll(CombinatorParser.expr, input)
    if (result.isEmpty) {
      println("This expression could not be parsed")
    } else {
      import behaviors._
      val expr = result.get
      println("The parsed expression is: ")
      println(toFormattedString(expr))
      println("It has size " + size(expr) + " and height " + height(expr))
      println("It evaluates to " + evaluate(expr))
    }
  }

  if (args.length > 0) {
    processExpr(args mkString " ")
  } else {
    print("Enter infix expression: ")
    scala.io.Source.stdin.getLines() foreach { line =>
      processExpr(line)
      print("Enter infix expression: ")
    }
  }
}
