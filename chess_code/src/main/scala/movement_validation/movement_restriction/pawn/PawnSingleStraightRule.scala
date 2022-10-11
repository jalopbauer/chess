package movement_validation.movement_restriction.pawn:
  
  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.{MovementRestriction, ToPositionIsEmpty}
  import piece.PieceColor
  
  case class PawnSingleStraightRule() extends MovementRestriction :
    val boardCoordinateIsEmpty: MovementRestriction = ToPositionIsEmpty()
  
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      val from = moveRestrictionInput.movement.from
      val to = moveRestrictionInput.movement.to
      val vector = to.vector(from)
      val piece = moveRestrictionInput.board.getPieceInBoardCoordinate(from).get
      ((vector == BoardCoordinate(0, 1) && piece.color == PieceColor("WHITE")) || (vector == BoardCoordinate(0, -1) && piece.color == PieceColor("BLACK"))) && boardCoordinateIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput)
