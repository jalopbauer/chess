package movement_validation.movement_restriction:
  
  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor
  
    case class MovementIsSurrounding() extends MovementRestriction:
      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        val movement = moveRestrictionInput.movement
        val vector = movement.to.vector(movement.from)
        (vector.x * vector.y).abs == 1

