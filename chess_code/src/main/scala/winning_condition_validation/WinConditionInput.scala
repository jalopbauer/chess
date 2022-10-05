package winning_condition_validation:
  import board.Board
  import movement.Turn
  case class WinConditionInput(board: Board, turns: List[Turn])
