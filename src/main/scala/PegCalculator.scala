package edu.luc.cs.laufer.cs473.expressions

import org.parboiled2.ParseError
import scala.util.{Failure, Success}

object PegCalculator extends App {

  def processExpr(input: String): Unit = {
    println("You entered: " + input)
    val parser = new PegParser(input)
    parser.InputLine.run() match {
      case Failure(error: ParseError) =>
        println("This expression could not be parsed:")
        println(parser.formatError(error))
      case Failure(error) =>
        println("This expression could not be evaluated: " + error)
      case Success(expr) =>
        import behaviors._
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
    scala.io.Source.stdin.getLines foreach { line =>
      processExpr(line)
      print("Enter infix expression: ")
    }
  }
}
