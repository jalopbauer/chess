package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorKinghtFactory(xPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val horse = Some(Piece(pieceColor, PieceType("HORSE")))
      Map(BoardCoordinate(xPos, 2) -> horse, BoardCoordinate(xPos, 7) -> horse)
      