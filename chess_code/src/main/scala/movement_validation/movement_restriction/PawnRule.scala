package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput

  case class PawnRule() extends MovementRestriction:
    val pawnSingleStraightRule: MovementRestriction = PawnSingleStraightRule()
    val pawnDoubleStraightRule: MovementRestriction = PawnDoubleStraightRule()
    val pawnDiagonalRule: MovementRestriction = PawnDiagonalRule()
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean = {
      pawnSingleStraightRule.checkIfRestrictionIsMet(moveRestrictionInput)
        || pawnDoubleStraightRule.checkIfRestrictionIsMet(moveRestrictionInput)
        || pawnDiagonalRule.checkIfRestrictionIsMet(moveRestrictionInput)
    }