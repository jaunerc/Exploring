package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;

/**
 * This component represents a graphical object in the world.
 */
public class VisualComponent implements Component, Pool.Poolable {
    public TextureRegion textureRegion;
    public Color color;
    public int renderLevel;

    public VisualComponent(TextureRegion textureRegion, Color color, int renderLevel) {
        this.textureRegion = textureRegion;
        this.color = color;
        this.renderLevel = renderLevel;
    }

    @Override
    public void reset() {
        textureRegion = null;
        color = null;
        renderLevel = 0;
    }
}
