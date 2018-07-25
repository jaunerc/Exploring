package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

/**
 * This component represents a position in the world.
 */
public class PositionComponent implements Component, Pool.Poolable {
    public Vector2 vector;

    public PositionComponent(float x, float y) {
        vector = new Vector2(x, y);
    }

    @Override
    public void reset() {
        vector.x = 0f;
        vector.y = 0f;
    }
}
