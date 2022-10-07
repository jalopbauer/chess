package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorBishopFactory(yPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val bishop = Some(Piece(pieceColor, PieceType("BISHOP")))
      Map(BoardCoordinate(3, yPos) -> bishop, BoardCoordinate(6,yPos) -> bishop)