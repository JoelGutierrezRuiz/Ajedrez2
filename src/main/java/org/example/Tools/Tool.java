package org.example.Tools;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinate;
import org.example.Pieces.Piece;

import java.util.Arrays;
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

    public static Piece getPiece (Board board, Piece.Color color) throws Exception {

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
                else if(!(piece.getColor().equals(color))){
                    throw new Exception("Turn for "+ color.toString().toLowerCase() );
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
                System.out.print("Escribe la coordenada: ");
                Scanner sc =  new Scanner(System.in);
                String coordenada = sc.nextLine().toLowerCase();
                if(coordenada.length() != 2){
                    throw new Exception("Introduce una coordenada válida");
                }
                if(coordenada.charAt(0) < 'a' || coordenada.charAt(0)>'h'){
                    throw new Exception ("Introduce una coordenada válida");
                }
                if(coordenada.charAt(1) < '1' || coordenada.charAt(1) > '8'){
                    throw new Exception ("Introduce una coordenada válida");
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


}
