package org.example.Game;

import org.example.Pieces.Piece;
import org.example.Tools.Tool;

public class WhitePlayer {

    private String name;
    private Piece.Color color;

    public WhitePlayer() {
        this.color = Piece.Color.WHITE;
        this.name = Tool.getName(color.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
