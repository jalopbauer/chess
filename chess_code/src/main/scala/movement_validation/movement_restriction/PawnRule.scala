package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput

  case class PawnRule() extends MovementRestriction:
    val pawnSingleStraightRule: MovementRestriction = PawnSingleStraightRule()
    val pawnDoubleStraightRule: MovementRestriction = PawnDoubleStraightRule()
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean = {
      val bool = pawnSingleStraightRule.checkIfRestrictionIsMet(moveRestrictionInput)
      val bool1 = pawnDoubleStraightRule.checkIfRestrictionIsMet(moveRestrictionInput)
      bool ||
        bool1
        || {
        val movement = moveRestrictionInput.movement
        val from = movement.from
        val to = movement.to
        val vector = to.vector(from)
        val maybeFromPiece = moveRestrictionInput.board.getPieceInBoardCoordinate(from)
        val maybeToPiece = moveRestrictionInput.board.getPieceInBoardCoordinate(to)
        val value = maybeFromPiece.get
        val value1 = maybeToPiece.get
        (vector == BoardCoordinate(1, 1)
          || vector == BoardCoordinate(-1, 1))
          && value.color != value1.color
      }
    }