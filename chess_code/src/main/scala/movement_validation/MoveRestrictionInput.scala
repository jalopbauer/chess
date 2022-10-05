package movement_validation:
  import board.Board
  import movement.{Movement, Turn}
  case class MoveRestrictionInput(movement: Movement, board: Board, turns :List[Turn])