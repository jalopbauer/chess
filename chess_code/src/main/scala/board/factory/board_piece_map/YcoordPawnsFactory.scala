package board.factory.board_piece_map:
  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}
  case class YcoordPawnsFactory(xPos: Int, pieceColor: PieceColor, yCoordMaxValue: Int):
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      (1 to yCoordMaxValue).map(y => {BoardCoordinate(xPos, y)}).map(k => k -> Some(Piece(pieceColor, PieceType("PAWN")))).toMap