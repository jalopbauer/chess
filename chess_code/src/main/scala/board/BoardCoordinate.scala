package board:
  case class BoardCoordinate(x: Int, y: Int):
    def vector(boardCoordinate: BoardCoordinate):BoardCoordinate =
      BoardCoordinate(x-boardCoordinate.x, y-boardCoordinate.y)
    override def toString: String =
      s"($x, $y)"

  case object BoardCoordinate:
    def apply(tentativeBoardCoordinate: TentativeBoardCoordinate): BoardCoordinate = {
      BoardCoordinate(tentativeBoardCoordinate.x, tentativeBoardCoordinate.y)
    }
