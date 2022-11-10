package edu.luc.cs.laufer.cs371.expressions

object TestFixtures:

  import Expr.*
  import Operator.*

  val complex1 =
    Binary(
      Binary(
        Binary(
          Constant (1),
          Plus,
          Constant(2)
        ),
        Minus,
        Binary(
          Constant(3),
          Times,
          Constant(4)
        )
      ),
      Div,
      Constant(5)
    )

  val complex1string = "((1 + 2) - (3 * 4)) / 5"

  val complex1string2 = "  ((1 + 2) - (3 * 4)) / 5  "

  val complex2 =
    Binary(
      Binary(
        Binary(
          Constant(1),
          Plus,
          Constant(2)
        ),
        Minus,
        Binary(
          Unary(
            Minus, 
            Constant(3)
          ),
          Times,
          Constant(4)
        )
      ),
      Mod,
      Constant(5)
    )

end TestFixtures
