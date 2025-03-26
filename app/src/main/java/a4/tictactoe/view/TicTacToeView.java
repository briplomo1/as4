package a4.tictactoe.view;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import a4.tictactoe.MainActivity;

/**
 * View class contains methods to update front end {@link View}s with the current state
 * of the app.
 * */
public class TicTacToeView {
    private final MainActivity mainActivity;
    private final Button[][] boardButtons;
    private final TextView XScore;
    private final TextView OScore;
    private final TextView draws;
    private final TextView directions;

    public TicTacToeView(final MainActivity mainActivity, Button[][] boardButtons,
                         final TextView XScore, final TextView OScore, final TextView draws, final TextView directions) {
        this.mainActivity = mainActivity;
        this.boardButtons = boardButtons;
        this.OScore = OScore;
        this.XScore = XScore;
        this.draws = draws;
        this.directions = directions;
    }

    /**
     * Sets board button text by taking a row and column and setting the text of the button
     * to the marker specified.
     * @param row The row of the button
     * @param col The column of the button
     * @param marker The marker to set the button to
     * */
    public void setBoardButton(int row, int col, String marker) {
        boardButtons[row][col].setText(marker);
    }

    /**
     * Sets board button color by taking a row and column and setting the color of the button
     * to the given {@link ColorInt}.
     * @param row The row of the button
     * @param col The column of the button
     * @param color The color to set the button to
     * */
    public void setBoardButtonColor(int row, int col, @ColorInt int color) {
        boardButtons[row][col].setHighlightColor(color);
    }

    /**
     * Updates player X's score to a given integer in the view.
     * @param newScore The new score to set X's score to
     * */
    public void setXScore(int newScore) {
        XScore.setText(newScore);
    }

    /**
     * Updates player O's score to a given integer in the view.
     * @param newScore The new score to set O's score to
     * */
    public void setOScore(int newScore) {
        OScore.setText(newScore);
    }

    /**
     * Updates the number of draws to a given integer in the view.
     * @param newScore The new integer to set draws to
     * */
    public void setDraws(int newScore) {
        draws.setText(newScore);
    }

    /**
     * Updates the directions view text to a direct the next player ready in the view.
     * @param next The next player to set the text to
     * */
    public void setNextPlayer(final String next) {
        directions.setText(String.format("Ready player %s", next));
    }


    /**
     * Updates the directions view text to display the winner of the match.
     * @param winner The winning marker of the match
     * */
    public void setWinner(final String winner) {
        directions.setText(String.format("Player %s wins!", winner));
    }

    /**
     * Sets the board model to a blank state.
     * Sets the game's view to a new game by clearing all moves from the board
     * and setting the next player to X.
     * */
    public void resetBoard() {
        for (TextView[] v: boardButtons) {
            for (TextView t: v) {
                t.setText("");
                t.setHighlightColor(Color.BLUE);
            }
        }
        setNextPlayer("X");
    }


}
