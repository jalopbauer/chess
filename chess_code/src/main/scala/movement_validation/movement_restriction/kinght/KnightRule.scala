package movement_validation.movement_restriction.kinght:

  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.MovementRestriction

    case class KnightRule() extends MovementRestriction :
      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        val to = moveRestrictionInput.movement.to
        val from = moveRestrictionInput.movement.from
        val diff = to.vector(from)
        val optionalToPiece = moveRestrictionInput.board.getPieceInBoardCoordinate(to)
        val fromPiece = moveRestrictionInput.board.getPieceInBoardCoordinate(from).get
        (diff.x * diff.y).abs == 2 && (optionalToPiece.isEmpty || (optionalToPiece.get.color != fromPiece.color))
