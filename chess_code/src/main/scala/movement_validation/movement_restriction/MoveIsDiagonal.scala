package movement_validation.movement_restriction
  
  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor
  
  case class MoveIsDiagonal() extends MovementRestriction:
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      val to = moveRestrictionInput.movement.to
      val from = moveRestrictionInput.movement.from
      val diff = to.vector(from)
      diff.x.abs == diff.y.abs

