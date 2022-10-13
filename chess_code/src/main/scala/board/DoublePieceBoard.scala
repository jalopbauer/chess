package board

import movement.Movement
import piece.{Piece, PieceColor, PieceType}

  case class DoublePieceBoard(coordinate1: BoardCoordinate, piece1: Piece, coordinate2: BoardCoordinate, piece2: Piece) extends Board:

    def makeMovement(movement: Movement): DoublePieceBoard =
    this

    def getPieceInBoardCoordinate(boardCoordinate: BoardCoordinate): Option[Piece] =

      boardCoordinate match
        case BoardCoordinate(coordinate1.x,coordinate1.y) => Some(piece1)
        case BoardCoordinate(coordinate2.x,coordinate2.y) => Some(piece2)
        case _ => None

    def getBoardCoordinate(tentativeBoardCoordinate: TentativeBoardCoordinate): Option[BoardCoordinate] =
      Some(BoardCoordinate(tentativeBoardCoordinate))

    def getPieces:Map[BoardCoordinate,Option[Piece]]=
      Map()

    def removePiece(boardCoordinate: BoardCoordinate): Board =
      this