package a4.tictactoe.controller;

import android.graphics.Color;
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
        if(board.addMarker(row, col)) {
            view.setBoardButton(row, col, board.getMarker(row, col).toString());
        }
        Position[] win = board.winningPositions(board.getMarker(row, col));
        if(win != null) {
            for(Position p: win) {
                view.setBoardButtonColor(p.getRow(), p.getCol(), Color.RED);
            }
        }
        view.setWinner(board.getMarker(row, col).toString());
    }

    /**
     * Calls the board to reset its state and the view to reset its state to a blank and new game
     * */
    public void newButtonSelected() {
        board.resetBoard();
        view.resetBoard();
    }

}
