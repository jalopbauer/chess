package board:

  import movement.Movement
  import piece.{Piece, PieceColor, PieceType}

  case class RegularBoard (pieces:Map[BoardCoordinate, Option[Piece]]) extends Board:
    def makeMovement(movement: Movement): RegularBoard =
    this
    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece] =
      pieces(boardCoordinate)

    def getBoardCoordinate(tentativeBoardCoordinate: TentativeBoardCoordinate): Option[BoardCoordinate] =
      Some(BoardCoordinate(tentativeBoardCoordinate))

    def getPieces:Map[BoardCoordinate,Option[Piece]]=
        pieces

    def removePiece(boardCoordinate: BoardCoordinate): Board =
      RegularBoard(pieces.removed(boardCoordinate))