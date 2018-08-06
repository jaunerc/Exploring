package ch.travbit.exploring.world.climate.temperate;

import ch.travbit.exploring.world.climate.BaseLifeZone;
import com.badlogic.gdx.graphics.Texture;

public final class ForestLifeZone extends BaseLifeZone {

    public ForestLifeZone(Texture texture) {
        super(new ForestTileFactory(texture));
    }
}
