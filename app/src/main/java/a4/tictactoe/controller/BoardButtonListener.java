package a4.tictactoe.controller;

import android.view.View;

/**
 * A listener class that updates the app state when a button on the TicTacToe board is clicked.
 *
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
        controller.
    }
}
