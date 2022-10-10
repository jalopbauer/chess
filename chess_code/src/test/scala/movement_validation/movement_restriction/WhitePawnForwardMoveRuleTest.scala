package movement_validation.movement_restriction

import board.{BoardCoordinate, RegularBoard, SinglePieceBoard}
import board.factory.RegularBoardFactory
import movement.Movement
import movement_validation.MoveRestrictionInput
import org.scalatest.funsuite.AnyFunSuite
import piece.{Piece, PieceColor, PieceType}

class WhitePawnForwardMoveRuleTest extends AnyFunSuite {

  val pawnRules: MovementRestriction = PawnRule()
  val whiteColor: PieceColor = PieceColor("WHITE")
  val pawnType: PieceType = PieceType("PAWN")
  val whitePawn: Piece = Piece(whiteColor,pawnType)

  val initialBoardCoordinate: BoardCoordinate = BoardCoordinate(2,2)
  val initialCoordinateBoard: SinglePieceBoard = SinglePieceBoard(initialBoardCoordinate,whitePawn)

  test("Single move forward test initial position"){
    val movement = Movement(initialBoardCoordinate,BoardCoordinate(2, 3))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard,List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test initial position") {
    val movement = Movement(initialBoardCoordinate, BoardCoordinate(2, 4))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val initialBoardCoordinate2: BoardCoordinate = BoardCoordinate(3, 2)
  val initialCoordinateBoard2: SinglePieceBoard = SinglePieceBoard(initialBoardCoordinate2, whitePawn)

  test("Single move forward test initial position redundancy") {
    val movement = Movement(initialBoardCoordinate2, BoardCoordinate(3, 3))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard2, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test initial position redundancy") {
    val movement = Movement(initialBoardCoordinate2, BoardCoordinate(3, 4))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard2, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val movedBoardCoordinate: BoardCoordinate = BoardCoordinate(2, 3)
  val movedCoordinateBoard: SinglePieceBoard = SinglePieceBoard(movedBoardCoordinate, whitePawn)

  test("Single move forward test moved position") {
    val movement = Movement(movedBoardCoordinate, BoardCoordinate(2, 4))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test moved position") {
    val movement = Movement(movedBoardCoordinate, BoardCoordinate(2, 5))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard, List())
    assert(!pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val movedBoardCoordinate2: BoardCoordinate = BoardCoordinate(3, 3)
  val movedCoordinateBoard2: SinglePieceBoard = SinglePieceBoard(movedBoardCoordinate2, whitePawn)

  test("Single move forward test moved position redundancy") {
    val movement = Movement(movedBoardCoordinate2, BoardCoordinate(3, 4))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard2, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test moved position redundancy") {
    val movement = Movement(movedBoardCoordinate2, BoardCoordinate(3, 5))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard2, List())
    assert(!pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }
}