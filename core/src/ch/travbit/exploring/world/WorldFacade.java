package ch.travbit.exploring.world;

import ch.travbit.exploring.ExploringGame;
import com.badlogic.ashley.core.PooledEngine;

public class WorldFacade {

    private WorldFacade() {
    }

    public static World createExploringWorld(ExploringGame game, PooledEngine engine) {
        return new ExploringWorld(game, engine);
    }
}
