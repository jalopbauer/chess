package board.factory.board_piece_map:
  
  import board.BoardCoordinate
  import piece.{Piece, PieceColor}

  case class RegularKnightsFactory() extends BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      RegularSingleColorKinghtFactory(1,PieceColor("WHITE")).createPieces() ++ RegularSingleColorKinghtFactory(8,PieceColor("BLACK")).createPieces()