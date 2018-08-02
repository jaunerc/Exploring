package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.world.tilemap.tiles.WaterTileFactory;
import com.badlogic.gdx.graphics.Texture;

public class WaterLifeZone extends BaseLifeZone {

    public WaterLifeZone(Texture texture) {
        super(new WaterTileFactory(texture));
    }
}
