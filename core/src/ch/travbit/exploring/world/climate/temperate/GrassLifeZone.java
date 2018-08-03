package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.world.tilemap.tiles.GrassTileFactory;
import com.badlogic.gdx.graphics.Texture;

public class GrassLifeZone extends BaseLifeZone {

    public GrassLifeZone(Texture texture) {
        super(new GrassTileFactory(texture));
    }
}
