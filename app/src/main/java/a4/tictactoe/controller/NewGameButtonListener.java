package a4.tictactoe.controller;

import android.util.Log;
import android.view.View;

/**
 * Class that implements {@link View.OnClickListener} and its {@link #onClick(View)} method. Handles the event when the new game button is pressed.
 * */
public class NewGameButtonListener implements View.OnClickListener {
    private final TicTacToeController controller;

    public NewGameButtonListener(final TicTacToeController cont) {
        this.controller = cont;
    }

    @Override
    public void onClick(View view) {
        Log.i("NewGameButtonListener", "New game button pressed");
        controller.newButtonSelected();
    }
}
