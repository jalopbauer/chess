package board.factory.board_piece_map:

  import board.BoardCoordinate
  import piece.{Piece, PieceColor}

  case class RegularBishopsFactory() extends BoardPieceMapFactory:
    val whiteBishops: RegularSingleColorBishopFactory = RegularSingleColorBishopFactory(1,PieceColor("WHITE"))
    val blackBishops: RegularSingleColorBishopFactory = RegularSingleColorBishopFactory(8,PieceColor("BLACK"))
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      whiteBishops.createPieces() ++ blackBishops.createPieces()