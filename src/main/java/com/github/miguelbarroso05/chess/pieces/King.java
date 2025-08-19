package com.github.miguelbarroso05.chess.pieces;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.chess.ChessPiece;
import com.github.miguelbarroso05.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }

}
