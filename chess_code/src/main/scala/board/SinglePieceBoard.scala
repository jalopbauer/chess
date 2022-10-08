package board:

  import movement.Movement
  import piece.{Piece, PieceColor, PieceType}

    case class SinglePieceBoard(coordinate: BoardCoordinate, piece: Piece) extends Board:
      def makeMovement(movement: Movement): SinglePieceBoard =
      this

      def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece] =
        boardCoordinate match
          case coordinate if coordinate == boardCoordinate => Some(piece)
          case _ => None

      def getBoardCoordinate(tentativeBoardCoordinate: TentativeBoardCoordinate): Option[BoardCoordinate] =
        Some(BoardCoordinate(tentativeBoardCoordinate))

      