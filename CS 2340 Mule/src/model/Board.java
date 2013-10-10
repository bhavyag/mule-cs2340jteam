package model;

public abstract class Board {
    public static Board constructBoard(int boardType) {
        Board board = null;

        switch (boardType) {
            case 0:
                board = new Map1();
                break;
            case 1:
                board = new Map2();
                break;
            default:
                return null;
        }

        return board;
    }
}
