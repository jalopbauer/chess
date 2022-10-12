package movement_validation.movement_restriction:

  import board.{Board, BoardCoordinate}
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor

    case class StraightPathIsEmpty() extends MovementRestriction:
      val moveIsDiagonal: MovementRestriction = MoveIsStraight()

      def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
        moveIsDiagonal.checkIfRestrictionIsMet(moveRestrictionInput)
          && {
          val to = moveRestrictionInput.movement.to
          val from = moveRestrictionInput.movement.from
          val diff = to.vector(from)
          if (to.x == 0)
            val maxI: Int = diff.y
            def coordinate = (i:Int) => BoardCoordinate(to.x, to.y + i)
            myMethod(maxI,coordinate,moveRestrictionInput.board)
          else
            val maxI: Int = diff.x
            def coordinate = (i:Int) => BoardCoordinate(to.x +i, to.y)
            myMethod(maxI,coordinate,moveRestrictionInput.board)
          }

      private def myMethod(maxI:Int, coordinate:Int => BoardCoordinate, board:Board): Boolean =
        (1 to maxI).foldLeft(true)((acc, i)
        => {
          val boardCoordinate = coordinate(i)
          val maybePiece = board.getPieceInBoardCoordinate(boardCoordinate)
          maybePiece.isEmpty && acc
        })
;
