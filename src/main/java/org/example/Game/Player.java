package org.example.Game;

import org.example.Pieces.Piece;
import org.example.Tools.Tool;

public class Player {

    private String name;
    private Piece.Color color;

    public Player(Piece.Color color) {
        this.color = color;
        this.name = Tool.getName(color.toString());
    }


    public String getName() {
        return name;
    }

    public Piece.Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name;
    }
}
