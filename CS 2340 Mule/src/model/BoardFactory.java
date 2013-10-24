package model;

public class BoardFactory {
    public static Board constructBoard(int boardType) {
        switch (boardType) {
            case 0:
                return new Map1();
            case 1:
                return new Map2();
            default:
                return null;
        }
    }
}
