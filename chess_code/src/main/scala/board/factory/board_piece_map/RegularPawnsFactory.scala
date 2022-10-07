package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor}

  case class RegularPawnsFactory() extends BoardPieceMapFactory:
    val whitePawns: YcoordPawnsFactory = YcoordPawnsFactory(2,PieceColor("WHITE"), 8)
    val blackPawns: YcoordPawnsFactory = YcoordPawnsFactory(7,PieceColor("BLACK"), 8)
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      val pieces = whitePawns.createPieces().concat(blackPawns.createPieces())
      pieces