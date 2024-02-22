package org.example.Pieces;

import org.example.Game.Board;
import org.example.Game.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {
    public Queen(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate> nextMovements = new HashSet<>();

        nextMovements.addAll(Bishop.getNextMovementsAsBishop(this));
        nextMovements.addAll(Rook.getNextMovementsAsRook(this));

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_QUEEN), WHITE(Piece.Type.WHITE_QUEEN);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
