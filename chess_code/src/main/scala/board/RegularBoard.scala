package board:

  import movement.Movement
  import piece.Piece

  case class RegularBoard(boardPieces: Array[Array[Option[Piece]]] = Array.ofDim(8,8)) extends Board:

    def makeMovement(movement: Movement): RegularBoard =
      val newBoard = boardPieces.clone()
      RegularBoard(newBoard)

    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece] =
      None

