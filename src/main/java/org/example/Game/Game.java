package org.example.Game;

import org.example.Pieces.*;
import org.example.Tool;

import java.awt.*;

public class Game {


    public static void main(String[] args) throws Exception {

        Board board = new Board();

        Piece.Color color= Piece.Color.WHITE;
        DeletePieceManager pieceManager  = new DeletePieceManager(board);

        do{
            /**/


            board.print();
            pieceManager.print();
            Piece aux = Tool.getPiece(board,color);


            System.out.println(aux.getColor());

            board.highLight(aux.getNextMovements());

            board.print();
            board.removeHighLight(aux.getNextMovements());

            Tool.move(aux);

            board.print();

            color =Tool.changeTurn(color);

            pieceManager.refreshRemaining();





        }while (true);



    }

}
