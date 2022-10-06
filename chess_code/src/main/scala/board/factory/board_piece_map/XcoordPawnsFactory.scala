package board.factory.board_piece_map:
  import board.BoardCoordinate
  import piece.{Piece, PieceColor, PieceType}
  case class XcoordPawnsFactory(yPos: Int, pieceColor: PieceColor, xCoordMaxValue: Int):
    def createPieces(): Map[BoardCoordinate, Option[Piece]] =
      (1 to xCoordMaxValue).map(x => {BoardCoordinate(x, yPos)}).map(k => k -> Some(Piece(pieceColor, PieceType("PAWN")))).toMap