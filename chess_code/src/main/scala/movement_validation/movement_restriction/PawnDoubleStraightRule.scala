package movement_validation.movement_restriction:
  
  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  
    case class PawnDoubleStraightRule() extends MovementRestriction:
      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        val from = moveRestrictionInput.movement.from
        val to = moveRestrictionInput.movement.to
        val vector = to.vector(from)
        val piece = moveRestrictionInput.board.getPieceInBoardCoordinate(BoardCoordinate(to.x, to.y +1))
        (vector == BoardCoordinate(0, 2) && from.y == 2) || (vector == BoardCoordinate(0, -2) && from.y == 7) && piece.isEmpty