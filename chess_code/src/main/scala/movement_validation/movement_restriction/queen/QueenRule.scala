package movement_validation.movement_restriction.queen

import movement_validation.MoveRestrictionInput
import movement_validation.movement_restriction.{DiagonalPathIsEmpty, MoveIsDiagonal, MovementRestriction, StraightPathIsEmpty, ToPiecePositionIsDifferentColor, ToPositionIsEmpty}
  
    case class QueenRule() extends MovementRestriction :
      val diagonalPathIsEmpty: MovementRestriction = DiagonalPathIsEmpty()
      val straightPathIsEmpty: MovementRestriction = StraightPathIsEmpty()
      val toPositionIsDifferentColor: MovementRestriction = ToPiecePositionIsDifferentColor()
      val toPositionIsEmpty: MovementRestriction = ToPositionIsEmpty()
      
      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        (diagonalPathIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput) || straightPathIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput))
          && (toPositionIsEmpty.checkIfRestrictionIsMet(moveRestrictionInput) || toPositionIsDifferentColor.checkIfRestrictionIsMet(moveRestrictionInput))
