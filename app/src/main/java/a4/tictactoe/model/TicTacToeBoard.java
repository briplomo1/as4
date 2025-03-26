package a4.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {
    private Marker currentPlayer = Marker.X;

    private int moveCount = 0;
    private Position lastMove;
    private Marker[][] markers;

    /**
     * Adds a move to the board by changing the value in the array
     * */
    public boolean addMarker(int row, int col) {
        if (markers[row][col] != null) {
            return false;
        }
        markers[row][col] = currentPlayer;
        currentPlayer = Marker.valueOf(!currentPlayer.getValue());
        moveCount++;
        return true;
    }

    /**
     *
     * */
    public Marker getMarker(int row, int col) {
        return markers[row][col];
    }

    /**
     * Based of last made move. Determines if the last player has made a winning move and returns
     * an array of the winning moves or null if there is no win.
     * @param marker The player marker who were looking for a win
     * @return A {@link Position} array if a win is found or null.
     * */
    public Position[] winningPositions(Marker marker) {
        int count = 0;
        List<Position> pos = new ArrayList<>();
        // Not possible to have a win in less than 5 moves or if no move has been made
        if(lastMove == null || moveCount < 5) return null;

        // Check col
        for (int i = 0; i < 3; i++) {
            if (markers[lastMove.getRow()][i] == marker) {
                count++;
                pos.add(new Position(lastMove.getRow(), i));
            } else {
                pos.clear();
                count = 0;
                break;
            }
        }
        // Check row
        for (int i = 0; i < 3; i++) {
            if (markers[i][lastMove.getCol()] == marker) {
                count++;
                pos.add(new Position(i, lastMove.getCol()));
            } else {
                pos.clear();
                count = 0;
                break;
            }

        }
        // Top left to bot right diagonal
        if (lastMove.getRow() == lastMove.getCol()) {
            for (int i = 0; i < 3; i++) {
                if(markers[i][i] == marker) {
                    count++;
                    pos.add(new Position(i, i));
                } else {
                    pos.clear();
                    count = 0;
                    break;
                }
            }
        }

        // Check other diagonal
        if(lastMove.getRow()+ lastMove.getCol() == 2) {
            for (int i = 0; i < 3; i++) {
                if(markers[2-i][i] == marker) {
                    count++;
                    pos.add(new Position(2-i, i));
                } else {
                    pos.clear();
                    break;
                }
            }
        }

        return count == 3 ? pos.toArray(new Position[0]) : null;
    }

    public int numUnplayedSquares() {
        return 9-moveCount;
    }

    public void resetBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                markers[i][j] = null;
            }
        }
        this.moveCount = 0;
        lastMove = null;
    }


}
