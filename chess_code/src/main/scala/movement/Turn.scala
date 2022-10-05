package movement:
  import piece.Piece
  case class Turn(performedMovement: Movement, piece: Option[Piece], player: Player)
