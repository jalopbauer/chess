package board.factory

import board.{Board, BoardCoordinate, RegularBoard}
import helper.GetPieceInRegularBoard
import org.scalatest.compatible.Assertion
import org.scalatest.funsuite.AnyFunSuite
import piece.{Piece, PieceColor, PieceType}

class RegularBoardFactoryTest extends AnyFunSuite {
  val regularBoard: RegularBoard = RegularBoardFactory().createBoard()

  val whiteColor: PieceColor = PieceColor("WHITE")
  val blackColor: PieceColor = PieceColor("BLACK")

  val whitePawn: Piece = Piece(whiteColor, PieceType("PAWN"))
  val blackPawn: Piece = Piece(blackColor, PieceType("PAWN"))

  def pieceEquals(expected: Piece, board: RegularBoard, boardCoordinate: BoardCoordinate): Assertion =
    val actualPiece:Piece = GetPieceInRegularBoard.getPieceInBoardCoordinate(board, boardCoordinate)
    assert(actualPiece === expected)

  test("Pawn in BoardCoordinate(2, 1)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 1))
  }

  test("Pawn in BoardCoordinate(2, 2)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 2))
  }

  test("Pawn in BoardCoordinate(2, 3)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 3))
  }

  test("Pawn in BoardCoordinate(2, 4)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 4))
  }

  test("Pawn in BoardCoordinate(2, 5)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 5))
  }

  test("Pawn in BoardCoordinate(2, 6)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 6))
  }

  test("Pawn in BoardCoordinate(2, 7)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 7))
  }

  test("Pawn in BoardCoordinate(2, 8)") {
    pieceEquals(whitePawn,regularBoard,BoardCoordinate(2, 8))
  }

  test("Pawn in BoardCoordinate(7, 1)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 1))
  }

  test("Pawn in BoardCoordinate(7, 2)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 2))
  }

  test("Pawn in BoardCoordinate(7, 3)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 3))
  }

  test("Pawn in BoardCoordinate(7, 4)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 4))
  }

  test("Pawn in BoardCoordinate(7, 5)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 5))
  }

  test("Pawn in BoardCoordinate(7, 6)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 6))
  }

  test("Pawn in BoardCoordinate(7, 7)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 7))
  }

  test("Pawn in BoardCoordinate (7, 8)") {
    pieceEquals(blackPawn,regularBoard,BoardCoordinate(7, 8))
  }

  val blackBishop: Piece = Piece(blackColor,PieceType("BISHOP"))
  val whiteBishop: Piece = Piece(whiteColor,PieceType("BISHOP"))

  test("Bishop in BoardCoordinate (3, 8)") {
    pieceEquals(blackBishop, regularBoard, BoardCoordinate(3, 8))
  }

  test("Bishop in BoardCoordinate (6, 8)") {
    pieceEquals(blackBishop, regularBoard, BoardCoordinate(6,8))
  }

  test("Bishop in BoardCoordinate (3, 1)") {
    pieceEquals(whiteBishop, regularBoard, BoardCoordinate(3,1))
  }

  test("Bishop in BoardCoordinate (6, 1)") {
    pieceEquals(whiteBishop, regularBoard, BoardCoordinate(6,1))
  }

  val blackKnight: Piece = Piece(blackColor, PieceType("KNIGHT"))
  val whiteKnight: Piece = Piece(whiteColor, PieceType("KNIGHT"))

  test("Knight in BoardCoordinate (8, 2)") {
    pieceEquals(blackKnight, regularBoard, BoardCoordinate(8, 2))
  }

  test("Knight in BoardCoordinate (8, 7)") {
    pieceEquals(blackKnight, regularBoard, BoardCoordinate(8, 7))
  }

  test("Knight in BoardCoordinate (1, 2)") {
    pieceEquals(whiteKnight, regularBoard, BoardCoordinate(1, 2))
  }

  test("Knight in BoardCoordinate (1, 7)") {
    pieceEquals(whiteKnight, regularBoard, BoardCoordinate(1, 7))
  }

  val blackRook: Piece = Piece(blackColor, PieceType("ROOK"))
  val whiteRook: Piece = Piece(whiteColor, PieceType("ROOK"))

  test("Rook in BoardCoordinate (1, 8)") {
    pieceEquals(blackRook, regularBoard, BoardCoordinate(1, 8))
  }

  test("Rook in BoardCoordinate (8, 8)") {
    pieceEquals(blackRook, regularBoard, BoardCoordinate(8, 8))
  }

  test("Rook in BoardCoordinate (1, 1)") {
    pieceEquals(whiteRook, regularBoard, BoardCoordinate(1, 1))
  }

  test("Rook in BoardCoordinate (8, 1)") {
    pieceEquals(whiteRook, regularBoard, BoardCoordinate(8, 1))
  }

  val blackQueen: Piece = Piece(blackColor, PieceType("QUEEN"))
  val whiteQueen: Piece = Piece(whiteColor, PieceType("QUEEN"))

  test("Queen in BoardCoordinate (4, 1)") {
    pieceEquals(whiteQueen, regularBoard, BoardCoordinate(4, 1))
  }

  test("Queen in BoardCoordinate (4, 8)") {
    pieceEquals(blackQueen, regularBoard, BoardCoordinate(4, 8))
  }

}
