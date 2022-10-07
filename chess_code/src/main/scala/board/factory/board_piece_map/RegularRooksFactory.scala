package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor}

  case class RegularRooksFactory() extends BoardPieceMapFactory:
    val whiteRooks: RegularSingleColorRooksFactory = RegularSingleColorRooksFactory(1,PieceColor("WHITE"))
    val blackRooks: RegularSingleColorRooksFactory = RegularSingleColorRooksFactory(8,PieceColor("BLACK"))
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      whiteRooks.createPieces() ++ blackRooks.createPieces()