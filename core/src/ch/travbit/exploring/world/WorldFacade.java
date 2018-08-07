package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import ch.travbit.exploring.util.config.ConfigKey;
import com.badlogic.ashley.core.PooledEngine;

/**
 * This class is a facade to create worlds.
 */
public final class WorldFacade {

    private WorldFacade() {
    }

    public static World createExploringWorld(ExploringGame game, PooledEngine engine) {
        int chunkSize = game.getGameConfig().getIntValue(ConfigKey.CHUNK_SIZE);
        int pixelsPerMeter = game.getGameConfig().getIntValue(ConfigKey.PIXELS_PER_METER);
        return new ExploringWorld(game, engine, chunkSize, pixelsPerMeter);
    }
}
