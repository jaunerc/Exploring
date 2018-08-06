package ch.travbit.exploring.util;

/**
 * Represents the tile textures in the asset directory.
 */
public enum TileAsset {
    TILE_GRASS("tiles/grass.png"), TILE_WATER("tiles/water.png"), TILE_FOREST("tiles/forest.png"),
    TILE_SAND("tiles/sand.png");

    private String path;

    TileAsset(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
