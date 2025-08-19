package com.github.miguelbarroso05;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.boardgame.Position;
import com.github.miguelbarroso05.chess.ChessPiece;
import com.github.miguelbarroso05.chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
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
        // above
        newPosition.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setRow(newPosition.getRow() - 1);
        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        // left
        newPosition.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setColumn(newPosition.getColumn() - 1);
        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        // right
        newPosition.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setColumn(newPosition.getColumn() + 1);
        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        // below
        newPosition.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
            newPosition.setRow(newPosition.getRow() + 1);
        }
        if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }
        return mat;
    }

    @Override
    public String toString() {
        return "Q";
    }

}
