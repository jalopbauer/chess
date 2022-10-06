package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorBishopFactory(xPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val bishop = Some(Piece(pieceColor, PieceType("BISHOP")))
      Map(BoardCoordinate(xPos,3) -> bishop, BoardCoordinate(xPos,6) -> bishop)