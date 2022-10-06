package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularQueensFactory() extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val pieceType = PieceType("QUEEN")
      Map(BoardCoordinate(4,1) -> Some(Piece(PieceColor("WHITE"), pieceType)), BoardCoordinate(4,8) -> Some(Piece(PieceColor("BLACK"), pieceType)))