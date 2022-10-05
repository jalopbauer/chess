package board:
  import movement.{Movement, Turn}
  import piece.Piece
  trait Board():
    def makeMoveMovement(movement: Movement): Option[Turn]
    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece]