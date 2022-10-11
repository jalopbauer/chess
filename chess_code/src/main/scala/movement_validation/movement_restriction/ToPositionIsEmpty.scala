package movement_validation.movement_restriction

import board.BoardCoordinate
import movement_validation.MoveRestrictionInput
import piece.PieceColor

case class ToPositionIsEmpty() extends MovementRestriction:
  def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
    val to = moveRestrictionInput.movement.to
    moveRestrictionInput.board.getPieceInBoardCoordinate(to).isEmpty

