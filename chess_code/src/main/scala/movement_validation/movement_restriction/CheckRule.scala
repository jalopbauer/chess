package movement_validation.movement_restriction:

  import board.BoardCoordinate
  import check_checker.CheckChecker
  import movement_validation.MoveRestrictionInput
  import piece.PieceColor

  case class CheckRule(checkChecker: CheckChecker) extends MovementRestriction:
    def checkIfRestrictionIsMet(moveRestrictionInput: MoveRestrictionInput): Boolean =
      val from = moveRestrictionInput.movement.from
      val board = moveRestrictionInput.board
      val piece = board.getPieceInBoardCoordinate(from).get
      checkChecker.checkCheck(piece.color,from,board)