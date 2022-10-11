package movement_validation.movement_restriction.pawn

import board.factory.RegularBoardFactory
import board.{BoardCoordinate, DoublePieceBoard, RegularBoard, SinglePieceBoard}
import movement.Movement
import movement_validation.MoveRestrictionInput
import movement_validation.movement_restriction.{MovementRestriction, PawnRule}
import org.scalatest.funsuite.AnyFunSuite
import piece.{Piece, PieceColor, PieceType}

class BlackPawnMoveRuleTest extends AnyFunSuite {

  val pawnRules: MovementRestriction = PawnRule()
  val whiteColor: PieceColor = PieceColor("WHITE")
  val blackColor: PieceColor = PieceColor("BLACK")
  val pawnType: PieceType = PieceType("PAWN")
  val whitePawn: Piece = Piece(whiteColor,pawnType)
  val blackPawn: Piece = Piece(blackColor,pawnType)

  val initialBoardCoordinate: BoardCoordinate = BoardCoordinate(7,7)
  val initialCoordinateBoard: SinglePieceBoard = SinglePieceBoard(initialBoardCoordinate,blackPawn)

  test("Single move forward test initial position"){
    val movement = Movement(initialBoardCoordinate,BoardCoordinate(7, 6))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard,List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test initial position") {
    val movement = Movement(initialBoardCoordinate, BoardCoordinate(7, 5))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val initialBoardCoordinate2: BoardCoordinate = BoardCoordinate(8, 7)
  val initialCoordinateBoard2: SinglePieceBoard = SinglePieceBoard(initialBoardCoordinate2, blackPawn)

  test("Single move forward test initial position redundancy") {
    val movement = Movement(initialBoardCoordinate2, BoardCoordinate(8, 6))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard2, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test initial position redundancy") {
    val movement = Movement(initialBoardCoordinate2, BoardCoordinate(8, 5))
    val movementRestriction = MoveRestrictionInput(movement, initialCoordinateBoard2, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val movedBoardCoordinate: BoardCoordinate = BoardCoordinate(7, 6)
  val movedCoordinateBoard: SinglePieceBoard = SinglePieceBoard(movedBoardCoordinate, blackPawn)

  test("Single move forward test moved position") {
    val movement = Movement(movedBoardCoordinate, BoardCoordinate(7, 5))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test moved position") {
    val movement = Movement(movedBoardCoordinate, BoardCoordinate(7, 4))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard, List())
    assert(!pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val movedBoardCoordinate2: BoardCoordinate = BoardCoordinate(8, 6)
  val movedCoordinateBoard2: SinglePieceBoard = SinglePieceBoard(movedBoardCoordinate2, blackPawn)

  test("Single move forward test moved position redundancy") {
    val movement = Movement(movedBoardCoordinate2, BoardCoordinate(8, 5))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard2, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  test("Double move forward test moved position redundancy") {
    val movement = Movement(movedBoardCoordinate2, BoardCoordinate(8, 4))
    val movementRestriction = MoveRestrictionInput(movement, movedCoordinateBoard2, List())
    assert(!pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val pawnPieceCoordinate: BoardCoordinate = BoardCoordinate(5, 5)
  val diagonalPieceCoordinatePositive: BoardCoordinate =  BoardCoordinate(4, 4)
  val twoPieceBoardDifferentColor: DoublePieceBoard = DoublePieceBoard(pawnPieceCoordinate, whitePawn, diagonalPieceCoordinatePositive, blackPawn)

  test("Diagonal pawn eat BoardCoordinate(4, 4)"){
    val movement = Movement(pawnPieceCoordinate, diagonalPieceCoordinatePositive)
    val movementRestriction = MoveRestrictionInput(movement, twoPieceBoardDifferentColor, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val twoPieceBoardSameColor: DoublePieceBoard = DoublePieceBoard(pawnPieceCoordinate, whitePawn, diagonalPieceCoordinatePositive, whitePawn)

  test("Diagonal pawn cannot eat BoardCoordinate(4, 4)") {
    val movement = Movement(pawnPieceCoordinate, diagonalPieceCoordinatePositive)
    val movementRestriction = MoveRestrictionInput(movement, twoPieceBoardSameColor, List())
    assert(!pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val diagonalPieceCoordinateNegative: BoardCoordinate =  BoardCoordinate(6, 4)
  val twoPieceBoardDifferentColorNegative: DoublePieceBoard = DoublePieceBoard(pawnPieceCoordinate, whitePawn, diagonalPieceCoordinateNegative, blackPawn)

  test("Diagonal pawn eat BoardCoordinate(6, 4)") {
    val movement = Movement(pawnPieceCoordinate, diagonalPieceCoordinateNegative)
    val movementRestriction = MoveRestrictionInput(movement, twoPieceBoardDifferentColorNegative, List())
    assert(pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

  val twoPieceBoardSameColorNegative: DoublePieceBoard = DoublePieceBoard(pawnPieceCoordinate, whitePawn, diagonalPieceCoordinateNegative, whitePawn)

  test("Diagonal pawn cannot eat BoardCoordinate(6, 4)") {
    val movement = Movement(pawnPieceCoordinate, diagonalPieceCoordinateNegative)
    val movementRestriction = MoveRestrictionInput(movement, twoPieceBoardSameColorNegative, List())
    assert(!pawnRules.checkIfRestrictionIsMet(movementRestriction))
  }

}