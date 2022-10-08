package movement_validation.movement_restriction:

  import movement_validation.MoveRestrictionInput
  case class WhitePawnFowardMoveRule() extends MovementRestriction():
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      false
