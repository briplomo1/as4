package a4.tictactoe.controller;

import android.graphics.Color;
import android.util.Log;

import java.util.Arrays;

import a4.tictactoe.model.Marker;
import a4.tictactoe.model.Position;
import a4.tictactoe.model.TicTacToeBoard;
import a4.tictactoe.view.TicTacToeView;

/**
 * Controller class for the TicTacToe game. Handles intermediate logic between View events
 * and the model.
 */
public class TicTacToeController {
    private final TicTacToeView view;
    private final TicTacToeBoard board;
    public TicTacToeController(TicTacToeView view, TicTacToeBoard board) {
        this.view = view;
        this.board = board;
    }

    /**
     * Takes the row and column of a button selected by a player and calls the {@link TicTacToeBoard}
     * to add a marker to the board, then calls the {@link TicTacToeView} to update the view to reflect
     * the player move made. Checks if the last move resulted in a win and if so, calls the view to reflect
     * the win.
     * @param row The row of the button selected
     * @param col The column of the button selected
     * */
    public void boardButtonSelected(int row , int col) {
        // If match has already finished do nothing with user pressing board buttons
        if(board.getIsMatchOver()) return;
        // Make move
        if(board.addMarker(row, col)) {
            view.setBoardButtonText(row, col, board.getMarker(row, col).toString());
        }

        Position[] win = board.winningPositions(board.getMarker(row, col));
        Log.i("Controller", "Win: " + Arrays.toString(win));
        // Win found
        if(win != null) {
            board.setIsMatchOver(true);
            final Marker winner = board.getMarker(board.getLastMove().getRow(), board.getLastMove().getCol());
            // Update state in board
            if(winner == Marker.X) {
                int newXScore = board.getXScore()+1;
                board.setXScore(newXScore);
                view.setXScore(newXScore);
            } else {
                int newOScore = board.getOScore()+1;
                board.setOScore(newOScore);
                view.setOScore(newOScore);
            }
            for(Position p: win) {
                view.setBoardButtonColor(p.getRow(), p.getCol(), Color.RED);
            }
            view.setWinner(winner.toString());
            return;
        }
        // Draw found
        if(board.numUnplayedSquares() == 0) {
            board.setIsMatchOver(true);
            int newDraws = board.getDraws()+1;
            board.setDraws(newDraws);
            view.setDraws(newDraws);
            view.setGameIsDraw();
            return;
        }
        view.setNextPlayer(board.getCurrentPlayer().toString());
    }

    /**
     * Calls the board to reset its state and the view to reset its state to a blank and new game
     * */
    public void newButtonSelected() {
        board.resetBoard();
        view.resetBoard();
        view.setNextPlayer(board.getFirstTurn().toString());
    }

    /**
     * Set tic-tac-toe app initial state. Resets board. Sets scores and draws to 0.
     * */
    public void startGame() {
        board.resetBoard();
        view.setXScore(0);
        view.setOScore(0);
        view.setDraws(0);
        view.setNextPlayer(board.getFirstTurn().toString());
    }

}
