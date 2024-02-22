package org.example.Game;

import org.example.Pieces.Piece;
import static com.diogonunes.jcolor.Ansi.colorize;

import java.util.*;

public class DeletePieceManager {
    private List<Piece.Type> pieces;
    private Map<Piece.Type,Integer> deletedPieces;
    private Map<Piece.Type,Integer> remainingPieces;

    private Board board;

    public DeletePieceManager(Board board){
        pieces = Arrays.asList(Piece.Type.values());
        this.board = board;
        deletedPieces = new HashMap<>();
        remainingPieces = new HashMap<>();
        initDeleted();
        initRemaining();

    }


    private void initDeleted(){
        for(Piece.Type piece : pieces){
            deletedPieces.put( piece,0);
        }
    }
    public void initRemaining(){

        for(Piece.Type piece : pieces){
            remainingPieces.put(piece,0);
        }

        for(Cell cell : board.getCells().values()){

            if(!(cell.isEmpty())){
                remainingPieces.put(cell.getPiece().getType(),remainingPieces.get(cell.getPiece().getType())+1);
            }
        }

    }

    public void refreshRemaining(){

        HashMap<Piece.Type,Integer> aux = new HashMap<>(remainingPieces);
        remainingPieces=new HashMap<>();
        initRemaining();
        for(Piece.Type piece : pieces){
           if( aux.get(piece) != remainingPieces.get(piece) ){
               deletedPieces.put(piece,       aux.get(piece)-remainingPieces.get(piece)              );
           }
        }
    }

    public void print(){
        System.out.println("          REMAINING PIECES");
        printRemaining();
        System.out.println();
        System.out.println("          DELETED PIECES");
        printDeleted();

    }

    public void printDeleted(){

        String celda = "";
        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());
            celda+= colorize(piece.getShape(), piece.getColor().getAttribute(), Cell.Color.BLACK.getAttribute());
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());

        }
        celda+="\n";

        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());
            celda+= colorize(Integer.toString(deletedPieces.get(piece)), piece.getColor().getAttribute(), Cell.Color.WHITE.getAttribute());
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());

        }
        System.out.println(celda);
    }

    public void printRemaining(){

        String celda = "";
        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());
            celda+= colorize(piece.getShape(), piece.getColor().getAttribute(), Cell.Color.BLACK.getAttribute());
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());

        }
        celda+="\n";

        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());
            celda+= colorize(Integer.toString(remainingPieces.get(piece)), piece.getColor().getAttribute(), Cell.Color.WHITE.getAttribute());
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());

        }
        System.out.println(celda);
    }





}
