package org.example.Game;

import org.example.Pieces.Piece;
import org.example.Tools.Tool;

public class BlackPlayer {

    private String name;
    private Piece.Color color;

    public BlackPlayer() {
        this.color = Piece.Color.BLACK;
        this.name = Tool.getName(color.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
