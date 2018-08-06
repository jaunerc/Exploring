package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import ch.travbit.exploring.world.map.MapFactory;
import ch.travbit.exploring.world.map.TileMapFacade;
import ch.travbit.exploring.world.util.ChunkPos;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;

/**
 * This class represents the concrete in game world.
 */
public class ExploringWorld implements World {

    private ExploringGame game;
    private MapFactory mapFactory;
    private PooledEngine engine;
    private final int chunkSize;
    private final int pixelsPerMeter;

    public ExploringWorld(ExploringGame game, PooledEngine engine, int chunkSize, int pixelsPerMeter) {
        this.game = game;
        this.engine = engine;
        this.chunkSize = chunkSize;
        this.pixelsPerMeter = pixelsPerMeter;
        mapFactory = TileMapFacade.createExploringMapFactory(game.getAssetLoader());
    }

    @Override
    public void init() {
        mapFactory.init(this);
    }

    @Override
    public void expandWorld(float startCoordinateX, float startCoordinateY, ChunkPos chunkPos) {
        mapFactory.createTiles(engine, startCoordinateX, startCoordinateY, chunkPos);
        Gdx.app.debug("world expanded at chunk position", chunkPos.getX() + "," + chunkPos.getY());
        Gdx.app.debug("world expanded at world position", startCoordinateX + "," + startCoordinateY);
    }

    @Override
    public int getChunkSize() {
        return chunkSize;
    }

    @Override
    public int getPixelsPerMeter() {
        return pixelsPerMeter;
    }
}
