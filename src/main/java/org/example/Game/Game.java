package org.example.Game;
import org.example.Pieces.Piece;
import org.example.Tools.Tool;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    DeletePieceManager pieceManager;
    Piece.Color turnColor;
    public Game(){
        board = new Board();
        pieceManager = new DeletePieceManager(board);
        player1 = new Player(Piece.Color.WHITE);
        player2 = new Player(Piece.Color.BLACK);
        turnColor = player1.getColor();
    }



    public void start() throws Exception {

        int whiteWins ;
        int blackWins;
        do{
            /**/
            askTurn();

            whiteWins = pieceManager.findPiece(Piece.Type.BLACK_KING);
            blackWins = pieceManager.findPiece(Piece.Type.WHITE_KING);




        }while (whiteWins > 0 && blackWins > 0);

        if(whiteWins==0){
            System.out.println("The winner is White !!!!");
        }else{
            System.out.println("The winner is Black !!!!");
        }

    }

    private void askTurn() throws Exception {
        Tool.turnMessage( turnColor.equals(player1.getColor())?player1:player2 );
        board.print();
        pieceManager.print();
        Piece pieceTurn = Tool.getPiece(board,turnColor.equals(player1.getColor())?player1:player2 );
        board.highLight(pieceTurn.getNextMovements());
        board.print();
        pieceManager.print();
        board.removeHighLight(pieceTurn.getNextMovements());
        Tool.move(pieceTurn);
        turnColor = Tool.changeTurn(turnColor);
    }


}