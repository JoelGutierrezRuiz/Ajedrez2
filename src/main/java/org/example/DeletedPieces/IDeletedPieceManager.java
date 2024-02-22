package org.example.DeletedPieces;

import org.example.Pieces.Piece;

public interface IDeletedPieceManager {
    void addPiece(Piece piece);

    Piece removeLast();

    int count(Piece.Type pieceType);
}
