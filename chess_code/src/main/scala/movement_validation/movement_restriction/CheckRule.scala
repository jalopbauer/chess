package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor

  case class CheckRule(checkChecker: CheckChecker) extends MovementRestriction:
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      

