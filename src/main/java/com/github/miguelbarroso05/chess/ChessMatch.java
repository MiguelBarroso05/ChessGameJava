package com.github.miguelbarroso05.chess;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.boardgame.Position;
import com.github.miguelbarroso05.chess.pieces.King;
import com.github.miguelbarroso05.chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] match = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                match[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return match;
    }

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }
}
