package board:
  case class TentativeBoardCoordinate(x: Int, y: Int):
      override def toString: String =
        s"($x, $y)"