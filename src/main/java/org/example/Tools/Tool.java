package org.example.Tools;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinate;
import org.example.Game.Player;
import org.example.Pieces.Piece;

import java.util.Scanner;

public class Tool {
    public static void main(String[] args) throws Exception {
    }
    public static boolean move (Piece piece) throws Exception {

        while ((!piece.moveTo(getCoordinate()))){
            System.out.println("Invalid position");
        }
        return true;
    }

    public static Piece getPiece (Board board, Player player) throws Exception {

        do{
            try{
                Coordinate coordinate = getCoordinate();
                Cell cell = board.getCellAt(coordinate);
                Piece piece = cell.getPiece();
                if(piece==null){
                    throw new Exception("Esta celda esta vacía");
                }
                else if(piece.getNextMovements().isEmpty()){
                    throw new Exception("This piece cant move anywhere");
                }
                else if(!(piece.getColor().equals(player.getColor()))){
                    throw new Exception("Turn for "+ player.getColor().toString().toLowerCase()+": "+player.getName() );
                }
                else{
                    return board.getCellAt(coordinate).getPiece();
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    public static Coordinate getCoordinate(){
        do{
            try{
                System.out.print("Write the position: ");
                Scanner sc =  new Scanner(System.in);
                String coordenada = sc.nextLine().toLowerCase();
                if(coordenada.length() != 2){
                    throw new Exception("Introduce a valid position.");
                }
                if(coordenada.charAt(0) < 'a' || coordenada.charAt(0)>'h'){
                    throw new Exception ("Introduce a valid position.");
                }
                if(coordenada.charAt(1) < '1' || coordenada.charAt(1) > '8'){
                    throw new Exception ("Introduce a valid position.");
                }

                return new Coordinate(coordenada.charAt(0),Integer.parseInt(coordenada.substring(1)));

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    public static String getName(String color){
        do {
            try {
                String name = "";
                Scanner sc = new Scanner(System.in);
                System.out.print("Player " + color.toLowerCase() + " name: ");
                name = sc.nextLine();
                return name;
            } catch (Exception e) {
                System.out.print("Write a valid name!");
            }
        }while (true);
    }

    public static Piece.Color changeTurn(Piece.Color color){
        return color.equals(Piece.Color.BLACK)?Piece.Color.WHITE:Piece.Color.BLACK;

    }


    public static void turnMessage(Player player){

        System.out.println(player.getName()+" is your turn. Move a "+player.getColor().toString().toLowerCase()+" piece.");

    }



}
