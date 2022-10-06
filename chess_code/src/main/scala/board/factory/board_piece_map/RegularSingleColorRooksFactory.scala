package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorRooksFactory(xPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val rook = Some(Piece(pieceColor, PieceType("ROOK")))
      Map(BoardCoordinate(xPos,1) -> rook, BoardCoordinate(xPos,8) -> rook)