package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * This component represents a position in the world.
 */
public class PositionComponent implements Component {
    private Vector2 vector;

    public PositionComponent(float x, float y) {
        vector = new Vector2(x, y);
    }

    public Vector2 getVector() {
        return vector;
    }
}
