package helper:

  import board.{BoardCoordinate, RegularBoard}
  import piece.Piece

  case object GetPieceInRegularBoard:
    def getPieceInBoardCoordinate(regularBoard: RegularBoard, boardCoordinate: BoardCoordinate):Piece =
      regularBoard.getPieceInBoardCoordinate(boardCoordinate).get

