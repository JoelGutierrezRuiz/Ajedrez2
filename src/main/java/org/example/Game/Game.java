package org.example.Game;

import org.example.Pieces.*;
import org.example.Tools.Tool;

public class Game {


    public static void main(String[] args) throws Exception {

        Board board = new Board();
        WhitePlayer whitePlayer = new WhitePlayer();
        BlackPlayer blackPlayer =  new BlackPlayer();
        Piece.Color turnColor = Piece.Color.WHITE;
        DeletePieceManager pieceManager  = new DeletePieceManager(board);



        do{
            /**/

            board.print();
            pieceManager.print();

            Piece pieceTurn = Tool.getPiece(board,turnColor);

            board.highLight(pieceTurn.getNextMovements());
            board.print();
            pieceManager.print();

            board.removeHighLight(pieceTurn.getNextMovements());
            Tool.move(pieceTurn);

            board.print();
            pieceManager.print();
            pieceManager.refreshRemaining();
            turnColor = Tool.changeTurn(turnColor);


        }while (true);



    }

}
