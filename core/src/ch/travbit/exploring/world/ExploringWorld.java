package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import ch.travbit.exploring.world.tilemap.MapFactory;
import ch.travbit.exploring.world.tilemap.TileMapFacade;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;

import java.util.Random;

/**
 * This class represents the concrete in game world.
 */
public class ExploringWorld implements World {

    private ExploringGame game;
    private MapFactory mapFactory;
    private PooledEngine engine;
    private final int chunkSize;
    private final int pixelsPerMeter;

    private int climateRegionSeed;

    public ExploringWorld(ExploringGame game, PooledEngine engine, int chunkSize, int pixelsPerMeter) {
        this.game = game;
        this.engine = engine;
        this.chunkSize = chunkSize;
        this.pixelsPerMeter = pixelsPerMeter;
        mapFactory = TileMapFacade.createSimpleMapFactory(game.getAssetLoader());
    }

    @Override
    public void init() {
        Entity worldEntity = engine.createEntity();
        engine.addEntity(worldEntity);

        mapFactory.init(this);

        Random random = new Random();
        climateRegionSeed = random.nextInt();
    }

    @Override
    public void expandWorld(float startCoordinateX, float startCoordinateY) {
        mapFactory.createTiles(engine, startCoordinateX, startCoordinateY);
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
