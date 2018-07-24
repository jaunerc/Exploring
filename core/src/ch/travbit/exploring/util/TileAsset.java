package ch.travbit.exploring.util;

/**
 * Represents the tile textures in the asset directory.
 */
public enum TileAsset {
    TILE_GRASS("assets/tiles/grass.png");

    private String path;

    TileAsset(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
