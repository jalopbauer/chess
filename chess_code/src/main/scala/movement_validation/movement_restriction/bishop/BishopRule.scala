package movement_validation.movement_restriction.bishop:
  
  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.{DiagonalPathIsEmpty, MoveIsDiagonal, MovementRestriction, ToPiecePositionIsDifferentColor, ToPositionIsEmpty}
  
    case class BishopRule() extends MovementRestriction :
      val diagonalPathIsEmpty: MovementRestriction = DiagonalPathIsEmpty()
      val toPositionIsDifferentColor: MovementRestriction = ToPiecePositionIsDifferentColor()
      val toPositionIsEmpty: MovementRestriction = ToPositionIsEmpty()
      
      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        diagonalPathIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput)
          && (toPositionIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput) || toPositionIsDifferentColor.checkIfRestrictionIsMet(moveRestrictionInput))
