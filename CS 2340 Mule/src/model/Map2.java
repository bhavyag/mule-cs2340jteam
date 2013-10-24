package model;

public class Map2 extends Board {
    protected Map2() {
        this.map = new Tile[][] {
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.MOUNTAINONE),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTHREE)
                },
                {
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.MOUNTAINONE),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS)
                },
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.RIVER),
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER),
                        new Tile(Tile.Type.TOWN), new Tile(Tile.Type.RIVER),
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.RIVER),
                        new Tile(Tile.Type.PLAINS)
                },
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.MOUNTAINTWO),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTWO), new Tile(Tile.Type.RIVER),
                        new Tile(Tile.Type.RIVER)
                },
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINONE), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS)
                }
        };
    }

    public String toString() {
        return "map 2";
    }
}
