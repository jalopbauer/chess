package movement_validation.movement_restriction.king:

  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.{DiagonalPathIsEmpty, MoveIsDiagonal, MovementIsSurrounding, MovementRestriction, ToPiecePositionIsDifferentColor, ToPositionIsEmpty}

      case class KingRule() extends MovementRestriction :
        val toPositionIsDifferentColor: MovementRestriction = ToPiecePositionIsDifferentColor()
        val movementIsSurrounding: MovementRestriction = MovementIsSurrounding()
        val movementIsCastle: MovementRestriction = MovementIsCastle()
        val toPositionIsEmpty: MovementRestriction = ToPositionIsEmpty()

        def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
          (movementIsSurrounding.checkIfRestrictionIsMet(moveRestrictionInput) || movementIsCastle.checkIfRestrictionIsMet(moveRestrictionInput))
            && (toPositionIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput) || toPositionIsDifferentColor.checkIfRestrictionIsMet(moveRestrictionInput))