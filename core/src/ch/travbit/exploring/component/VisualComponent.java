package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;

/**
 * This component represents a graphical object in the world.
 */
public class VisualComponent implements Component, Pool.Poolable {
    private TextureRegion textureRegion;
    private Color color;

    public VisualComponent(TextureRegion textureRegion, Color color) {
        this.textureRegion = textureRegion;
        this.color = color;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void reset() {
        textureRegion = null;
        color = null;
    }
}
