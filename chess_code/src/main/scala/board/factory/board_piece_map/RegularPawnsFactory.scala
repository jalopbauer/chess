package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor}

  case class RegularPawnsFactory() extends BoardPieceMapFactory:
    val whitePawns: XcoordPawnsFactory = XcoordPawnsFactory(2,PieceColor("WHITE"), 8)
    val blackPawns: XcoordPawnsFactory = XcoordPawnsFactory(2,PieceColor("BLACK"), 8)
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      whitePawns.createPieces() ++ blackPawns.createPieces()