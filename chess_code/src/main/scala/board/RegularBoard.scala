package board:

  import movement.Movement
  import piece.{Piece, PieceColor, PieceType}

  case class RegularBoard (pieces:Map[BoardCoordinate, Option[Piece]]) extends Board:
    def makeMovement(movement: Movement): RegularBoard =
    this
    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Option[Piece]] =
      pieces.get(boardCoordinate)

