package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput

  case class PawnSingleStraightRule() extends MovementRestriction:
    val boardCoordinateIsEmpty: MovementRestriction = ToPositionIsEmpty()

    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      val from = moveRestrictionInput.movement.from
      val to = moveRestrictionInput.movement.to
      val vector = to.vector(from)
      (vector == BoardCoordinate(0, 1) || vector == BoardCoordinate(0, -1)) && boardCoordinateIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput)