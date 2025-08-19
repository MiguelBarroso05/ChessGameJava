package com.github.miguelbarroso05.chess.pieces;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.boardgame.Position;
import com.github.miguelbarroso05.chess.ChessMatch;
import com.github.miguelbarroso05.chess.ChessPiece;
import com.github.miguelbarroso05.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null & piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position newPosition = new Position(0, 0);
        // above
        newPosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // below
        newPosition.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // left
        newPosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // right
        newPosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // nw
        newPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // ne
        newPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // sw
        newPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // se
        newPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(newPosition) && canMove(newPosition)) {
            mat[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        // Castling
        if (getMoveCount() == 0 && !chessMatch.isCheck()) {
            Position psT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(psT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // left
            Position psT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(psT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }

}
