package a4.tictactoe;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import a4.tictactoe.controller.BoardButtonListener;
import a4.tictactoe.controller.NewGameButtonListener;
import a4.tictactoe.controller.TicTacToeController;
import a4.tictactoe.model.TicTacToeBoard;
import a4.tictactoe.view.TicTacToeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "Creating activity");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
    }

    private void initializeViews() {
        System.out.println("Initializing views");
        // Initialize views
        TextView XScore = findViewById(R.id.x_wins);
        TextView OScore = findViewById(R.id.o_wins);
        TextView draws = findViewById(R.id.draws);
        Button newGame = findViewById(R.id.new_game);
        TextView directions = findViewById(R.id.directions);
        Button[][] boardButtons = new Button[3][3];
        Resources res = getResources();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int id = res.getIdentifier("button_r" + i + "c" + j, "id", getPackageName());
                Button b = findViewById(id);
                b.setBackgroundColor(Color.BLUE);
                boardButtons[i][j] = b;
            }
        }
        newGame.setBackgroundColor(Color.BLUE);

        // Initialize the model, view, and controller
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeView view = new TicTacToeView(this, boardButtons, XScore, OScore, draws, directions);
        TicTacToeController controller = new TicTacToeController(view, board);

        // Set up the listeners for the board and new game buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardButtons[i][j].setOnClickListener(new BoardButtonListener(i, j, controller));
            }
        }

        newGame.setOnClickListener(new NewGameButtonListener(controller));
        controller.startGame();

    }



}