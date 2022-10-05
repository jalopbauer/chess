package movement_validation:
  import piece.PieceType
  trait PieceMovementRestrictionMapper:
    def getPieceTypeMovementRestriction(piece:PieceType):MovementRestriction
