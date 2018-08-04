package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import com.badlogic.ashley.core.PooledEngine;

/**
 * This class is a facade to create worlds.
 */
public class WorldFacade {

    private WorldFacade() {
    }

    public static World createExploringWorld(ExploringGame game, PooledEngine engine) {
        int chunkSize = 16;
        int pixelsPerMeter = 32;
        return new ExploringWorld(game, engine, chunkSize, pixelsPerMeter);
    }
}
