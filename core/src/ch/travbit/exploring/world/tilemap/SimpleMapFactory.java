package ch.travbit.exploring.world.tilemap;

import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.tilemap.tiles.GrassTileFactory;
import ch.travbit.exploring.world.tilemap.tiles.TileFactory;
import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;
import com.badlogic.ashley.core.PooledEngine;

public final class SimpleMapFactory implements MapFactory {
    private final static int TILE_WIDTH_PIXELS = 32;
    private final static int TILE_HEIGHT_PIXELS = 32;

    private TileFactory grassTileFactory;
    private int chunkSize;

    public SimpleMapFactory(AssetLoader assetLoader) {
        grassTileFactory = new GrassTileFactory(TILE_WIDTH_PIXELS, TILE_HEIGHT_PIXELS, assetLoader.getTile(TileAsset.TILE_GRASS));
    }

    @Override
    public void init(World world) {
        chunkSize = world.getChunkSize();
    }

    @Override
    public void createTiles(PooledEngine engine, int startX, int startY) {
        for (int i = startX; i < startX + chunkSize; i++) {
            for (int j = startY; j < startY + chunkSize; j++) {
                grassTileFactory.addTileToEngine(engine, i, j);
            }
        }
    }
}
