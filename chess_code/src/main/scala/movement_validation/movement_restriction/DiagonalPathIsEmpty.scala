package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor

  case class DiagonalPathIsEmpty() extends MovementRestriction:
    val moveIsDiagonal: MovementRestriction = MoveIsDiagonal()

    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      moveIsDiagonal.checkIfRestrictionIsMet(moveRestrictionInput)
        && {
        val to = moveRestrictionInput.movement.to
        val from = moveRestrictionInput.movement.from
        val diff = to.vector(from)
        val x: Int = diff.x
        (1 to x).foldLeft(true)((acc, i)
        => {
          val coordinate = BoardCoordinate(to.x + i, to.y + i)
          val maybePiece = moveRestrictionInput.board.getPieceInBoardCoordinate(coordinate)
          maybePiece.isEmpty && acc
        })
        }

