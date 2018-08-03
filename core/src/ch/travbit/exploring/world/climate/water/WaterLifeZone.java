package ch.travbit.exploring.world.climate.water;

import ch.travbit.exploring.world.climate.BaseLifeZone;
import com.badlogic.gdx.graphics.Texture;

public class WaterLifeZone extends BaseLifeZone {

    public WaterLifeZone(Texture texture) {
        super(new WaterTileFactory(texture));
    }
}
