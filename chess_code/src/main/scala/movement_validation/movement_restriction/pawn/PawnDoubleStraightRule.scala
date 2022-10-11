package movement_validation.movement_restriction.pawn:
  
  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.MovementRestriction
  import piece.PieceColor
  
  case class PawnDoubleStraightRule() extends MovementRestriction :
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      val from = moveRestrictionInput.movement.from
      val to = moveRestrictionInput.movement.to
      val vector = to.vector(from)
      val pieceInMiddle = moveRestrictionInput.board.getPieceInBoardCoordinate(BoardCoordinate(to.x, to.y + 1))
      val piece = moveRestrictionInput.board.getPieceInBoardCoordinate(from).get
      (vector == BoardCoordinate(0, 2) && from.y == 2 && piece.color == PieceColor("WHITE")) || (vector == BoardCoordinate(0, -2) && from.y == 7 && piece.color == PieceColor("BLACK")) && pieceInMiddle.isEmpty
