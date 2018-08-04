package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;

/**
 * This component represents a graphical object in the world.
 */
public class VisualComponent implements Component, Pool.Poolable {
    public TextureRegion textureRegion;
    public int renderLevel;
    public boolean visible = true;

    @Override
    public void reset() {
        textureRegion = null;
        renderLevel = 0;
        visible = true;
    }
}
