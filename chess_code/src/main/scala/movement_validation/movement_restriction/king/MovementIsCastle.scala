package movement_validation.movement_restriction.king:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import movement_validation.movement_restriction.*
  import piece.PieceColor

    case class MovementIsCastle() extends MovementRestriction :

      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        //        From is in either (5,1|8) 1:WHITE 8:BLACK

        def castleCheckFrom(moveRestrictionInput: MoveRestrictionInput): Boolean= {
          val movement = moveRestrictionInput.movement
          val from = movement.from
          val value = moveRestrictionInput.board.getPieceInBoardCoordinate(from).get
          from.x == 5 && ((from.y == 1 && value.color == PieceColor("WHITE")) || (from.y == 8 && value.color == PieceColor("BLACK")))
        }
        //        To is in either (3|7,1|8) 1:WHITE 8:BLACK
        def castleCheckTo(moveRestrictionInput: MoveRestrictionInput): Boolean = {
          val movement = moveRestrictionInput.movement
          val to = movement.to
          val from = movement.from
          val value = moveRestrictionInput.board.getPieceInBoardCoordinate(from).get
          ((to.y == 1 && value.color == PieceColor("WHITE")) || to.y == 8 && value.color == PieceColor("BLACK")) || (to.x == 3 || to.x == 5)
        }
        // No pieces can be between the king and the rook
        def castleCheckSpacesAreEmpty(moveRestrictionInput: MoveRestrictionInput): Boolean = {
          val movement = moveRestrictionInput.movement
          val from = movement.from
          val vector = from.vector(movement.to)
          val iFrom = {
            if (vector.x > 0)
              1
            else
              -1
          }
          (iFrom to vector.x).forall(i => moveRestrictionInput.board.getPieceInBoardCoordinate(BoardCoordinate(from.x + i, from.y)).isEmpty)
        }
        // Check if rook was moved
        def checkIfRookWasMoved(moveRestrictionInput: MoveRestrictionInput): Boolean = {
          val fromY = moveRestrictionInput.movement.from.y
          moveRestrictionInput.turns.forall(turn => {
            val fromTurn = turn.performedMovement.from
            (fromTurn.x != 1 && fromTurn.y != fromY) || (fromTurn.x != 8 && fromTurn.y != fromY)
          } )
        }
        // Check if king was moved
        def checkIfKingWasMoved(moveRestrictionInput: MoveRestrictionInput): Boolean = {
          val fromY = moveRestrictionInput.movement.from.y
          moveRestrictionInput.turns.forall(turn => {
            val fromTurn = turn.performedMovement.from
            fromTurn.x != 5 && fromTurn.y != fromY
          })
        }
        // You are not allowed to castle out of check
        // You are not allowed to castle through check
        castleCheckFrom(moveRestrictionInput)
          && castleCheckTo(moveRestrictionInput)
          && castleCheckSpacesAreEmpty(moveRestrictionInput)