package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;

/**
 * This class is a facade to create worlds.
 */
public class WorldFacade {

    private WorldFacade() {
    }

    public static World createExploringWorld(ExploringGame game, PooledEngine engine) {
        int chunkSize = 16;
        int pixelsPerMeter = 32; //todo params declaring outside of this class
        Gdx.app.debug("new world created with a chunksize of",""+chunkSize);
        return new ExploringWorld(game, engine, chunkSize, pixelsPerMeter);
    }
}
