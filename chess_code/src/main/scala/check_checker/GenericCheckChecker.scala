package check_checker:

  import board.{Board, BoardCoordinate}
  import movement.Movement
  import movement_validation.{MoveRestrictionInput, PieceMovementRestrictionMapper}
  import piece.{Piece, PieceColor, PieceType}

  case class GenericPositionCheckClhecker(pieceMovementRestrictionMapper: PieceMovementRestrictionMapper, kingColor:PieceColor) extends CheckChecker():
    def checkCheck(attackingColor:PieceColor, boardCoordinate: BoardCoordinate, board:Board): Boolean =
      val pieces = board.getPieces

      val myPiecesButKingCoordinates = pieces.filter(v =>
        v._2 match
          case None => false
          case Some(piece) => piece.color == kingColor && piece.pieceType != PieceType("KING")
      ).keys

      val boardWithoutMyPieces = myPiecesButKingCoordinates.foldLeft(board)((boardAcc, coordinate) => boardAcc.removePiece(coordinate))

      val enemyPieces = pieces.filter(v =>
        v._2 match
          case None => false
          case Some(piece) => piece.color != kingColor
      )

      enemyPieces.foldLeft(false)((acc, pieceCoordinate) => {
        val piece = pieceCoordinate._2.get
        val restriction = pieceMovementRestrictionMapper.getPieceTypeMovementRestriction(piece.pieceType)
        val movement = Movement(pieceCoordinate._1,boardCoordinate)
        val canMove = restriction.checkIfRestrictionIsMet(MoveRestrictionInput(movement, boardWithoutMyPieces, List()))
        acc || canMove
      })