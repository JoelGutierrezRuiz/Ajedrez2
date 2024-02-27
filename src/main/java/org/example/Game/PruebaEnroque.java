package org.example.Game;

import org.example.Pieces.King;
import org.example.Pieces.Piece;
import org.example.Tools.Tool;

import java.util.HashSet;
import java.util.Set;

public class PruebaEnroque {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        Piece.Color turnColor = Piece.Color.WHITE;
        board.print();

        do{
            /**/

            Piece pieceTurn = Tool.getPiece(board,turnColor);

            board.highLight(pieceTurn.getNextMovements());
            board.print();
            board.removeHighLight(pieceTurn.getNextMovements());
            Tool.move(pieceTurn);
            board.print();
            turnColor = Tool.changeTurn(turnColor);


        }while (true);

    }

}
