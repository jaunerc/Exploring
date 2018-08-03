package ch.travbit.exploring.world.climate.water;

import ch.travbit.exploring.world.climate.BaseTileFactory;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public final class WaterTileFactory extends BaseTileFactory {

    public WaterTileFactory(Texture texture) {
        super(texture, Color.BLUE);
    }
}
