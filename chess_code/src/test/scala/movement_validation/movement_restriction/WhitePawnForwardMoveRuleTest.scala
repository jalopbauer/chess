package movement_validation.movement_restriction

import board.{BoardCoordinate, RegularBoard, SinglePieceBoard}
import board.factory.RegularBoardFactory
import movement.Movement
import movement_validation.MoveRestrictionInput
import org.scalatest.funsuite.AnyFunSuite
import piece.{Piece, PieceColor, PieceType}

class WhitePawnForwardMoveRuleTest extends AnyFunSuite {

  val whiteColor: PieceColor = PieceColor("WHITE")
  val boardCoordinate: BoardCoordinate = BoardCoordinate(2,2)
  private val pawnType: PieceType = PieceType("PAWN")
  val whitePawn: Piece = Piece(whiteColor,pawnType)
  val pawnSecondPositionBoard: SinglePieceBoard = SinglePieceBoard(boardCoordinate,whitePawn)
  val pawnRules: MovementRestriction = PawnRule()

  test("Single move forward test"){
    val movement = Movement(boardCoordinate,BoardCoordinate(2, 3))
    val movementRestriction = MoveRestrictionInput(movement, pawnSecondPositionBoard,List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test") {
    val movement = Movement(boardCoordinate, BoardCoordinate(2, 4))
    val movementRestriction = MoveRestrictionInput(movement, pawnSecondPositionBoard, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

}