package check_checker:

  import board.{Board, BoardCoordinate}
  import piece.PieceColor

  trait CheckChecker:
    def checkCheck(attackingColor:PieceColor, boardCoordinate: BoardCoordinate, board:Board): Boolean