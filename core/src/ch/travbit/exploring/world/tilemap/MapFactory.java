package ch.travbit.exploring.world.tilemap;

import com.badlogic.ashley.core.PooledEngine;

/**
 * This interface provides methods to create maps.
 */
public interface MapFactory {

    /**
     * Initializes the factory.
     */
    void init();

    /**
     * Generates a new map.
     * @param engine pooled ashley engine.
     * @param mapWidth the number of tiles on the x-axis.
     * @param mapHeight the number of tiles on the y-axis.
     */
    void generateMap(PooledEngine engine, int mapWidth, int mapHeight);
}
