package ch.travbit.exploring.world;

import com.badlogic.gdx.math.Vector2;

/**
 * This interface provides methods to create and expand a world.
 */
public interface World {

    void init();

    void createWorldAroundPlayer(Vector2 playerPosition);

    void expandWorld(Vector2 playerPosition);

    int getChunkSize();

    int getPixelsPerMeter();
}
