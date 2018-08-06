package ch.travbit.exploring.world.climate.subtropics;

import ch.travbit.exploring.world.climate.BaseLifeZone;
import com.badlogic.gdx.graphics.Texture;

public final class DesertLifeZone extends BaseLifeZone {
    public DesertLifeZone(Texture texture) {
        super(new SandTileFactory(texture));
    }
}
