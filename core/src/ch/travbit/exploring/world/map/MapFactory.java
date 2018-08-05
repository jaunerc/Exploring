package ch.travbit.exploring.world.map;

import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.util.ChunkPos;
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
     * @param startCoordinateX the first coordinate on the x-axis.
     * @param startCoordinateY the first coordinate on the y-axis.
     * @param chunkPos the chunk position
     */
    void createTiles(PooledEngine engine, float startCoordinateX, float startCoordinateY, ChunkPos chunkPos);
}
