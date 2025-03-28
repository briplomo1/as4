package a4.tictactoe.controller;

import android.util.Log;
import android.view.View;

/**
 * Class that implements {@link View.OnClickListener} and its {@link #onClick(View)} method.
 * Handles the event when one of the board buttons is pressed.
 * */
public class BoardButtonListener implements View.OnClickListener {

    private final TicTacToeController controller;
    private final int row;
    private final int col;

    public BoardButtonListener(int row, int col, final TicTacToeController cont) {
        this.row = row;
        this.col = col;
        this.controller = cont;
    }

    @Override
    public void onClick(View v) {
        Log.i("BoardButtonListener", String.format("Board button row%s col%s pressed%n", row, col));
        controller.boardButtonSelected(row, col);
    }
}
