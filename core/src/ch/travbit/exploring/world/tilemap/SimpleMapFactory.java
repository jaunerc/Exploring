package ch.travbit.exploring.world.tilemap;

import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.tilemap.tiles.GrassTileFactory;
import ch.travbit.exploring.world.tilemap.tiles.TileFactory;
import ch.travbit.exploring.util.AssetLoader;
import ch.travbit.exploring.util.TileAsset;
import com.badlogic.ashley.core.PooledEngine;

public final class SimpleMapFactory implements MapFactory {

    private TileFactory grassTileFactory;
    private int chunkSize;
    private int pixelsPerMeter;

    public SimpleMapFactory(AssetLoader assetLoader) {
        grassTileFactory = new GrassTileFactory(assetLoader.getTile(TileAsset.TILE_GRASS));
    }

    @Override
    public void init(World world) {
        chunkSize = world.getChunkSize();
        pixelsPerMeter = world.getPixelsPerMeter();
    }

    @Override
    public void createTiles(PooledEngine engine, float startCoordinateX, float startCoordinateY) {
        int coordX;
        int coordY;
        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0; j < chunkSize; j++) {
                coordX = (int) (startCoordinateX + i * pixelsPerMeter);
                coordY = (int) (startCoordinateY + j * pixelsPerMeter);
                grassTileFactory.addTileToEngine(engine, coordX, coordY);
            }
        }
    }
}
