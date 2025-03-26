package a4.tictactoe.view;

import android.widget.TextView;
import android.widget.Toast;
import a4.tictactoe.MainActivity;

public class TicTacToeView {
    private final MainActivity mainActivity;
    private final TextView[] boardButtons;
    private final TextView XScore;
    private final TextView OScore;

    private final TextView nextPlayer;

    public TicTacToeView(final MainActivity mainActivity, final TextView[] boardButtons,
                         final TextView XScore, final TextView OScore, final TextView nextPlayer) {
        this.boardButtons = boardButtons;
        this.mainActivity = mainActivity;
        this.OScore = OScore;
        this.XScore = XScore;
        this.nextPlayer = nextPlayer;
    }

    public void setBoardButton() {

    }

    public void setXScore() {
    // TODO
    }

    public void setOScore() {
        // TODO
    }

    public void setNextPlayer(final String next) {
        nextPlayer.setText(String.format("Ready player %s", next));
    }

    public void winnerToast(final String winner) {
        Toast t = Toast.makeText(mainActivity, String.format("Player %s won!", winner), Toast.LENGTH_LONG);
        t.show();
    }




}
