package board
case class BoardCoordinate(x: Int, y: Int):
  override def toString: String =
    s"($x, $y)"
