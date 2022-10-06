package board.factory:
  import board.Board
  trait BoardFactory:
    def createBoard(): Board
