package board.factory:
  import board.factory.board_piece_map.{RegularBishopsFactory, RegularKingsFactory, RegularKnightsFactory, RegularPawnsFactory, RegularQueensFactory, RegularRooksFactory}
  import board.{BoardCoordinate, RegularBoard}
  import piece.{Piece, PieceColor, PieceType}
  class RegularBoardFactory extends BoardFactory:
    def createBoard(): RegularBoard =
      val pieces = RegularPawnsFactory().createPieces()
        ++ RegularKnightsFactory().createPieces()
        ++ RegularBishopsFactory().createPieces()
        ++ RegularRooksFactory().createPieces()
        ++ RegularQueensFactory().createPieces()
        ++ RegularKingsFactory().createPieces()
      RegularBoard(pieces)

