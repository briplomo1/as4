package com.example.tictactoe_tkq516.model;

public class Position {
    private int row;
    private int col;

    Position(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

}
