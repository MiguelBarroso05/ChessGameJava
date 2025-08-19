package com.github.miguelbarroso05.chess.pieces;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.boardgame.Position;
import com.github.miguelbarroso05.chess.ChessPiece;
import com.github.miguelbarroso05.chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position newPosition = new Position(0, 0);
        // nw
        newPosition.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() - 1, newPosition.getColumn() - 1);

        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        // ne
        newPosition.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() - 1, newPosition.getColumn() + 1);

        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        // se
        newPosition.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() + 1, newPosition.getColumn() + 1);

        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;

        }
        // sw
        newPosition.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setValues(newPosition.getRow() + 1, newPosition.getColumn() - 1);

        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        return mat;
    }

    @Override
    public String toString() {
        return "B";
    }

}
