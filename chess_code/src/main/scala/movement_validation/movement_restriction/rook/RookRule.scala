package movement_validation.movement_restriction.rook:
  
  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.{DiagonalPathIsEmpty, MovementRestriction, StraightPathIsEmpty, ToPiecePositionIsDifferentColor, ToPositionIsEmpty}
  
      case class RookRule() extends MovementRestriction :
        val straightPathIsEmpty: MovementRestriction = StraightPathIsEmpty()
        val toPositionIsDifferentColor: MovementRestriction = ToPiecePositionIsDifferentColor()
        val toPositionIsEmpty: MovementRestriction = ToPositionIsEmpty()
  
        def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
          straightPathIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput)
            && (toPositionIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput) || toPositionIsDifferentColor.checkIfRestrictionIsMet(moveRestrictionInput))
