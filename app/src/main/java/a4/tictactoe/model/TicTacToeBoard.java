package a4.tictactoe.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {
    private Marker currentPlayer = Marker.X;
    private Marker firstTurn = Marker.X;
    private int moveCount = 0;
    private Position lastMove;
    private final Marker[][] markers = new Marker[3][3];
    private int xScore = 0;
    private int oScore = 0;
    private int draws = 0;
    private boolean isMatchOver = false;

    public boolean getIsMatchOver() {
        return isMatchOver;
    }

    public Position getLastMove() {
        return lastMove;
    }

    public void setDraws(int newDraws) {
        draws = newDraws;
    }

    public int getDraws() {
        return draws;
    }

    public  void setXScore(int newScore) {
        xScore = newScore;
    }

    public void setOScore(int newScore) {
        oScore = newScore;
    }

    public int getXScore() {
        return xScore;
    }

    public int getOScore() {
        return oScore;
    }

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
        lastMove = new Position(row, col);
        return true;
    }

    /**
     *Return marker placed at a specific row and col
     * @param row The row of the button
     * @param col The column of the button
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
        Log.i("Board", String.format("Checking: %s row %d col %d", marker, lastMove.getRow(), lastMove.getCol()));
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
        if(count < 3) {
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
        }
        // Top left to bot right diagonal
        if (count < 3 && lastMove.getRow() == lastMove.getCol()) {
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
        if(count < 3 && lastMove.getRow()+ lastMove.getCol() == 2) {
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

    /**
     * Returns the number of unplayed squares on the board based of the count of all moves made thus far.
     * @return The number of unplayed squares
     * */
    public int numUnplayedSquares() {
        return 9-moveCount;
    }

    /**
     * Resets the board to a blank state by resetting all buttons markers to null, setting the first turn
     * to be the player hwo had the second  turn last match, and resetting the move count.
     * */
    public void resetBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                markers[i][j] = null;
            }
        }
        currentPlayer = Marker.valueOf(firstTurn.getValue());
        firstTurn = Marker.valueOf(!firstTurn.getValue());
        moveCount = 0;
        lastMove = null;
        isMatchOver = false;
    }

    /**
     * @return The marker of the player who had the first turn in the match
     * */
    public Marker getFirstTurn() {
        return Marker.valueOf(!(firstTurn.getValue()));
    }

    /**
     * @return The marker of the player whose turn it is
     * */
    public Marker getCurrentPlayer() {
        return currentPlayer;
    }

    public void setIsMatchOver(boolean b) {
        isMatchOver = b;
    }
}
