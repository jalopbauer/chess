package board:
  import movement.Movement
  import piece.Piece
  trait Board:
    def makeMovement(movement: Movement): Board
    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece]
    def getBoardCoordinate(tentativeBoardCoordinate: TentativeBoardCoordinate): Option[BoardCoordinate]
    def getPieces:Map[BoardCoordinate,Option[Piece]]
    
    def removePiece(boardCoordinate: BoardCoordinate): Board