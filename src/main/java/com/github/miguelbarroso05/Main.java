package com.github.miguelbarroso05;

import com.github.miguelbarroso05.boardgame.Board;
import com.github.miguelbarroso05.chess.ChessMatch;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
