package ch.travbit.exploring.world.climate;

import com.badlogic.ashley.core.PooledEngine;

/**
 * This interface provides a factory method to add a tile to the engine.
 */
public interface TileFactory {

    /**
     * Adds a new tile object to the engine.
     * @param engine pooled ashley engine.
     * @param tileX the tiles x-position on the map.
     * @param tileY the tiles y-position on the map.
     */
    void addTileToEngine(PooledEngine engine, int tileX, int tileY);
}
