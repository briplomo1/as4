package com.example.tictactoe_tkq516.model;

public enum Marker {
    X(true),
    O(false);

    private final boolean value;
    Marker(boolean i) {
        this.value = i;
    }

    public static Marker valueOf(boolean b) {
        return (b) ? Marker.X : Marker.O;
    }

    public boolean getValue() {
        return value;
    }
}
