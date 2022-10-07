package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorRooksFactory(yPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val rook = Some(Piece(pieceColor, PieceType("ROOK")))
      Map(BoardCoordinate(1,yPos) -> rook, BoardCoordinate(8, yPos) -> rook)