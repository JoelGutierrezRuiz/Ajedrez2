package org.example.Game;

import org.example.Pieces.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {

    private Map<Coordinate, Cell> cells;

    public Board() {
        cells = new HashMap<>();
        Coordinate c;
        for (int row = 1; row <= 8; row++) {
            for (char col = 'A'; col <= 'H'; col++) {
                c = new Coordinate(col, row);
                cells.put(c, new Cell(this, c));
            }
        }

        /*Knights*/
        Piece whiteKnight1 = new Knight(this,new Coordinate('B',1), Knight.Type.WHITE);
        Piece whiteKnight2 = new Knight(this,new Coordinate('G',1), Knight.Type.WHITE);

        Piece darkKnight1 = new Knight(this,new Coordinate('B',8), Knight.Type.BLACK);
        Piece darkKnight2 = new Knight(this,new Coordinate('G',8), Knight.Type.BLACK);

        /*Rooks*/

        Piece whiteRook1 = new Rook(this,new Coordinate('A',1), Rook.Type.WHITE);
        Piece whiteRook2 = new Rook(this,new Coordinate('H',1), Rook.Type.WHITE);

        Piece darkRook1 = new Rook(this,new Coordinate('A',8), Rook.Type.BLACK);
        Piece darkRook2 = new Rook(this,new Coordinate('H',8), Rook.Type.BLACK);

        /*Bishops*/

        Piece whiteBishop1 = new Bishop(this,new Coordinate('C',1), Bishop.Type.WHITE);
        Piece whiteBishop2 = new Bishop(this,new Coordinate('F',1), Bishop.Type.WHITE);

        Piece darkBishop1 = new Bishop(this,new Coordinate('C',8), Bishop.Type.BLACK);
        Piece darkBishop2 = new Bishop(this,new Coordinate('F',8), Bishop.Type.BLACK);

        /*Queen*/

        Piece whiteQueen = new Queen(this,new Coordinate('D',1), Queen.Type.WHITE);
        Piece darkQueen = new Queen(this,new Coordinate('D',8), Queen.Type.BLACK);

        /*King*/

        Piece whiteKing = new King(this,new Coordinate('E',1), King.Type.WHITE);
        Piece darkKing = new King(this,new Coordinate('E',8), King.Type.BLACK);

        /*Pawns white and black*/
        for(int i=0; i<8;i++ ){
            Piece peon = new Pawn(this,new Coordinate((char)('A'+i),2) ,Pawn.Type.WHITE );
        }
        for(int i=0; i<8;i++ ){
            Piece peon = new Pawn(this,new Coordinate((char)('A'+i),7) ,Pawn.Type.BLACK );
        }
    }
    public boolean contains(Coordinate c) {
        return cells.containsKey(c);
    }
    public Cell getCellAt(Coordinate c) {
        return cells.get(c);
    }
    public void highLight(Collection<Coordinate> coordinates) {
        for (Coordinate c : coordinates)
            getCellAt(c).highlight();
    }
    public void removeHighLight(Collection<Coordinate> coordinates){
        for (Coordinate c : coordinates)
            getCellAt(c).removeHighLight();
    }


    public Map<Coordinate, Cell> getCells() {
        return cells;
    }

    public void print(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String aux = "\t\t    A  B  C  D  E  F  G  H\n";
        for (int row = 1; row <= 8; row++) {
            aux += "\t\t " + row + " ";
            for (char col = 'A'; col <= 'H'; col++)
                aux += getCellAt(new Coordinate(col, row));
            aux += " " + row + "\n";
        }
        aux += "\t\t    A  B  C  D  E  F  G  H";
        return aux;
    }
}
