package model;

public class Tile
{
    /**
     * ENUM for Tile type
     */
    public static enum Type
    {
        MOUNTAINONE("mountain 1"),
        MOUNTAINTWO("mountain 2"),
        MOUNTAINTHREE("mountain 3"),
        PLAINS("plains"),
        RIVER("river"),
        TOWN("town");

        private String type;

        Type(String myType) {
            this.type = myType;
        }

        public String toString() {
            return type;
        }
    }

    private Type type;
    private static final Type[] types = {Type.MOUNTAINONE,Type.MOUNTAINTWO, Type.PLAINS, Type.RIVER, Type.TOWN};

    /**
     * CONTRUCTOR for Tiles
     */
    public Tile()
    {

    }
}
