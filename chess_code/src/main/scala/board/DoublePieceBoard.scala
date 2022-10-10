package board

import movement.Movement
import piece.{Piece, PieceColor, PieceType}

  case class DoublePieceBoard(coordinate1: BoardCoordinate, piece1: Piece, coordinate2: BoardCoordinate, piece2: Piece) extends Board:

    def makeMovement(movement: Movement): DoublePieceBoard =
    this

    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece] =

      boardCoordinate match
        case coordinate1 if coordinate1 == boardCoordinate => Some(piece1)
        case coordinate2 if coordinate2 == boardCoordinate => Some(piece2)
        case _ => None

    def getBoardCoordinate(tentativeBoardCoordinate: TentativeBoardCoordinate): Option[BoardCoordinate] =
      Some(BoardCoordinate(tentativeBoardCoordinate))

      