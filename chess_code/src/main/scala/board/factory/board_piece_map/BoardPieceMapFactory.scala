package board.factory.board_piece_map:
  import board.BoardCoordinate
  import piece.Piece
  
  trait BoardPieceMapFactory:
    def createPieces(): Map[BoardCoordinate, Option[Piece]]
