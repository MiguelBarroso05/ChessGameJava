package com.github.miguelbarroso05.chess.pieces;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.boardgame.Position;
import com.github.miguelbarroso05.chess.ChessPiece;
import com.github.miguelbarroso05.chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position newPosition = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            // move one up
            newPosition.setValues(this.position.getRow() - 1, this.position.getColumn());
            if (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            // if 1º move, move two up
            Position midPosition = newPosition; // the space in the middle of the two move
            newPosition.setValues(this.position.getRow() - 2, this.position.getColumn());
            if (getBoard().positionExists(newPosition) &&
                    !getBoard().thereIsAPiece(newPosition) &&
                    getBoard().positionExists(midPosition) &&
                    !getBoard().thereIsAPiece(midPosition) &&
                    this.getMoveCount() == 0) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }

            newPosition.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
            if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
            if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }
        } else {
            // BLACK PIECE
            // move one down
            newPosition.setValues(this.position.getRow() + 1, this.position.getColumn());
            if (getBoard().positionExists(newPosition) && !getBoard().thereIsAPiece(newPosition)) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            // if 1º move, move two down
            Position midPosition = newPosition; // the space in the middle of the two move
            newPosition.setValues(this.position.getRow() + 2, this.position.getColumn());
            if (getBoard().positionExists(newPosition) &&
                    !getBoard().thereIsAPiece(newPosition) &&
                    getBoard().positionExists(midPosition) &&
                    !getBoard().thereIsAPiece(midPosition) &&
                    this.getMoveCount() == 0) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }

            newPosition.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
            if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }
            newPosition.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
            if (getBoard().positionExists(newPosition) && isThereOpponentPiece(newPosition)) {
                mat[newPosition.getRow()][newPosition.getColumn()] = true;
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }

}
