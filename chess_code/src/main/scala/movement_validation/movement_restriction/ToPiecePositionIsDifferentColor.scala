package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor
  
  case class ToPiecePositionIsDifferentColor() extends MovementRestriction:
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      val to = moveRestrictionInput.movement.to
      val from = moveRestrictionInput.movement.from
      val board = moveRestrictionInput.board
      board.getPieceInBoardCoordinate(to).get.color != board.getPieceInBoardCoordinate(from).get.color
  
