package ch.travbit.exploring.world;

import com.badlogic.gdx.math.Vector2;

/**
 * This interface provides methods to create and expand a world.
 */
public interface World {

    void init();

    void expandWorld(float startCoordinateX, float startCoordinateY);

    int getChunkSize();

    int getPixelsPerMeter();
}
