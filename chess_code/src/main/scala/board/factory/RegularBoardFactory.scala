package board.factory:

  import board.factory.board_piece_map.{RegularBishopsFactory, RegularKnightsFactory, RegularPawnsFactory}
  import board.{BoardCoordinate, RegularBoard}
  import piece.{Piece, PieceColor, PieceType}

  class RegularBoardFactory extends BoardFactory:
    def createBoard(): RegularBoard =
      val pieces = RegularPawnsFactory().createPieces()
        ++ RegularKnightsFactory().createPieces()
        ++ RegularBishopsFactory().createPieces()
//        ++ RegularRooksFactory().createPieces()

      RegularBoard(pieces)

