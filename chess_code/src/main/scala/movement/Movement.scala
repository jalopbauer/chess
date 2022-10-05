package movement:
  import board.BoardCoordinate
  case class Movement(from: BoardCoordinate, to: BoardCoordinate):
    override def toString: String =
      s"($from, $to)"
