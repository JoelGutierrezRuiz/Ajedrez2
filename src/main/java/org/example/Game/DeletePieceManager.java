package org.example.Game;

import org.example.Pieces.Piece;
import static com.diogonunes.jcolor.Ansi.colorize;

import java.util.*;

public class DeletePieceManager {
    private List<Piece.Type> pieces;
    private Map<Piece.Type,Integer> deletedPieces;
    private Map<Piece.Type,Integer> remainingPieces;
    private Map<Piece.Type,Integer> totalPieces;


    private Board board;

    public DeletePieceManager(Board board){
        pieces = Arrays.asList(Piece.Type.values());
        this.board = board;
        deletedPieces = new HashMap<>();
        totalPieces = new HashMap<>();
        initDeleted();
        initTotalPieces();
        remainingPieces = new HashMap<>(totalPieces);

    }


    private void initDeleted(){
        for(Piece.Type piece : pieces){
            deletedPieces.put( piece,0);
        }
    }

    public void initTotalPieces(){

        for(Piece.Type piece : pieces){
            totalPieces.put(piece,0);
        }

        for(Cell cell : board.getCells().values()){

            if(!(cell.isEmpty())){
                totalPieces.put(cell.getPiece().getType(),totalPieces.get(cell.getPiece().getType())+1);
            }
        }

    }

    public int findPiece(Piece.Type type){
        int total = 0;
        for(Cell cell : board.getCells().values()) {

            if (!(cell.isEmpty()) && cell.getPiece().getType().equals(type) ) {
                total++;
            }


        }
        return total;
    }

    public void refreshRemaining(){

        for(Piece.Type piece : pieces){

            remainingPieces.put(piece, findPiece(piece));

           if( totalPieces.get(piece) > remainingPieces.get(piece) ){
               deletedPieces.put(piece,totalPieces.get(piece)-remainingPieces.get(piece)              );
           }

        }
    }

    public void print(){
        System.out.println("\t\t\t\tREMAINING PIECES");
        printRemaining();
        System.out.println();
        System.out.println("\t\t\t\tDELETED PIECES");
        printDeleted();

    }

    public void printDeleted(){

        String celda = "\t";
        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());
            celda+= colorize(piece.getShape(), piece.getColor().getAttribute(), Cell.Color.BLACK.getAttribute());
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());

        }
        celda+="\n\t";

        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());
            celda+= colorize(Integer.toString(deletedPieces.get(piece)), piece.getColor().getAttribute(), Cell.Color.WHITE.getAttribute());
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());

        }
        System.out.println(celda);
    }

    public void printRemaining(){

        String celda = "\t";
        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());
            celda+= colorize(piece.getShape(), piece.getColor().getAttribute(), Cell.Color.BLACK.getAttribute());
            celda+= colorize(" ",Cell.Color.BLACK.getAttribute());

        }
        celda+="\n\t";

        for(Piece.Type piece : pieces){
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());
            celda+= colorize(Integer.toString(remainingPieces.get(piece)), piece.getColor().getAttribute(), Cell.Color.WHITE.getAttribute());
            celda+= colorize(" ",Cell.Color.WHITE.getAttribute());

        }
        System.out.println(celda);
    }





}
