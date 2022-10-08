package board:
  case class BoardCoordinate(x: Int, y: Int):
    override def toString: String =
      s"($x, $y)"

  case object BoardCoordinate:
    def apply(tentativeBoardCoordinate: TentativeBoardCoordinate): BoardCoordinate = {
      BoardCoordinate(tentativeBoardCoordinate.x, tentativeBoardCoordinate.y)
    }
