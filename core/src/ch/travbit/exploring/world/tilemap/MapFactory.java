package ch.travbit.exploring.world.tilemap;

import ch.travbit.exploring.world.World;
import com.badlogic.ashley.core.PooledEngine;

/**
 * This interface provides methods to create maps.
 */
public interface MapFactory {

    /**
     * Initializes the factory.
     */
    void init(World world);

    /**
     * Creates tiles a new map.
     * @param engine pooled ashley engine.
     * @param startX the number of tiles on the x-axis.
     * @param startY the number of tiles on the y-axis.
     */
    void createTiles(PooledEngine engine, int startX, int startY);
}
