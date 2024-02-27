package org.example.Pieces;

import org.example.Game.Board;
import org.example.Game.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }


    @Override
    public Set<Coordinate> getNextMovements() {

        Coordinate position = getCell().getCoordinate();
        Set<Coordinate> nextMovements = new HashSet<>();

        getCastling(nextMovements);

        if (canAddToNextMovements(position.up()))
            nextMovements.add(position.up());

        if (canAddToNextMovements(position.up().right()))
            nextMovements.add(position.up().right());

        if (canAddToNextMovements(position.right())) {
            nextMovements.add(position.right());
        }
        if (canAddToNextMovements(position.down().right()))
            nextMovements.add(position.down().right());

        if (canAddToNextMovements(position.down()))
            nextMovements.add(position.down());

        if (canAddToNextMovements(position.down().left()))
            nextMovements.add(position.down().left());

        if (canAddToNextMovements(position.left())) {
            nextMovements.add(position.left());
        }


        if (canAddToNextMovements(position.up().left()))
            nextMovements.add(position.up().left());

        return nextMovements;
    }


    public void getCastling(Set<Coordinate> movements){
        Board board = this.getCell().getBoard();
        Coordinate position = this.getCell().getCoordinate();

        Piece whiteLeftRook = board.getCellAt( new Coordinate('A',1)).getPiece();
        Piece whiteRightRook = board.getCellAt( new Coordinate('H',1)).getPiece();
        Piece blackLeftRook = board.getCellAt( new Coordinate('A',8)).getPiece();
        Piece blackRightRook = board.getCellAt( new Coordinate('H',8)).getPiece();

        if(this.getType().equals(Piece.Type.WHITE_KING)  && !this.isMoved() ){
            if(whiteLeftRook!=null){
                if(!whiteLeftRook.isMoved()){
                    movements.add(position.left().left());
                }
            }
            if(whiteRightRook!=null){
                if(!whiteLeftRook.isMoved()){
                    movements.add(position.right().right());
                    movements.add(position.right().right().right());
                }
            }
        }
        if(this.getType().equals(Piece.Type.BLACK_KING)  && !this.isMoved() ){
            if(blackLeftRook!=null){
                if(!blackLeftRook.isMoved()){
                    movements.add(position.left().left());
                }
            }
            if(blackRightRook!=null){
                if(!blackRightRook.isMoved()){
                    movements.add(position.right().right());
                    movements.add(position.right().right().right());
                }
            }
        }
    }


    public enum Type {
        BLACK(Piece.Type.BLACK_KING), WHITE(Piece.Type.WHITE_KING);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
