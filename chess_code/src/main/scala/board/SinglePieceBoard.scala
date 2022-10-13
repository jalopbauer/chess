package board:

  import movement.Movement
  import piece.{Piece, PieceColor, PieceType}

    case class SinglePieceBoard(coordinate: BoardCoordinate, piece: Piece) extends Board:
      def makeMovement(movement: Movement): SinglePieceBoard =
      this

      def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece] =
        boardCoordinate match
          case BoardCoordinate(coordinate.x,coordinate.y) => Some(piece)
          case _ => None

      def getBoardCoordinate(tentativeBoardCoordinate: TentativeBoardCoordinate): Option[BoardCoordinate] =
        Some(BoardCoordinate(tentativeBoardCoordinate))

      def getPieces:Map[BoardCoordinate,Option[Piece]]=
        Map()

      def removePiece(boardCoordinate: BoardCoordinate): Board =
        this