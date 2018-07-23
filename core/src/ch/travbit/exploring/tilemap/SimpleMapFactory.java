package ch.travbit.exploring.tilemap;

import ch.travbit.exploring.tilemap.tiles.GrassTileFactory;
import ch.travbit.exploring.tilemap.tiles.TileFactory;
import com.badlogic.ashley.core.PooledEngine;

public class SimpleMapFactory implements MapFactory {
    private final static int TILE_WIDTH_PIXELS = 32;
    private final static int TILE_HEIGHT_PIXELS = 32;

    private TileFactory grassTileFactory;

    public SimpleMapFactory() {
        grassTileFactory = new GrassTileFactory(TILE_WIDTH_PIXELS, TILE_HEIGHT_PIXELS);
    }

    @Override
    public void init() {
        //ToDo
    }

    @Override
    public void generateMap(PooledEngine engine, int mapWidth, int mapHeight) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                grassTileFactory.addTileToEngine(engine, i, j);
            }
        }
    }
}
