package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularKingsFactory() extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val pieceType = PieceType("KING")
      Map(BoardCoordinate(5,1) -> Some(Piece(PieceColor("WHITE"), pieceType)), BoardCoordinate(5,8) -> Some(Piece(PieceColor("BLACK"), pieceType)))