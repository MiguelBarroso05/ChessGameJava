package com.github.miguelbarroso05;

import java.util.Scanner;

import com.github.miguelbarroso05.chess.ChessMatch;
import com.github.miguelbarroso05.chess.ChessPiece;
import com.github.miguelbarroso05.chess.ChessPosition;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);
            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
}
