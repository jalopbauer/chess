package movement_validation:
  import movement_validation.movement_restriction.MovementRestriction
  import piece.PieceType
  trait PieceMovementRestrictionMapper:
    def getPieceTypeMovementRestriction(piece:PieceType):MovementRestriction
