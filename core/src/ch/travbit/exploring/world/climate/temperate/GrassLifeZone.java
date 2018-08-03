package ch.travbit.exploring.world.climate.temperate;

import ch.travbit.exploring.world.climate.BaseLifeZone;
import com.badlogic.gdx.graphics.Texture;

public final class GrassLifeZone extends BaseLifeZone {

    public GrassLifeZone(Texture texture) {
        super(new GrassTileFactory(texture));
    }
}
