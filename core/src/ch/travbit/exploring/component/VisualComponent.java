package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class VisualComponent implements Component {
    private TextureRegion textureRegion;

    public VisualComponent(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }
}
