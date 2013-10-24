package model;

public class Map1 extends Board {
    protected Map1() {
        this.map = new Tile[][] {
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINONE), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTHREE), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS)
                },
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.MOUNTAINONE),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTHREE)
                },
                {
                        new Tile(Tile.Type.MOUNTAINTHREE), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.TOWN), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINONE)
                },
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.MOUNTAINTWO),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTWO), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS)
                },
                {
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTWO), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.RIVER), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.PLAINS), new Tile(Tile.Type.PLAINS),
                        new Tile(Tile.Type.MOUNTAINTWO)
                }
        };
    }

    public String toString() {
        return "map 1";
    }
}
