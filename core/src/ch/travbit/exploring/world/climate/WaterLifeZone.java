package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.world.tilemap.tiles.TileFactory;
import ch.travbit.exploring.world.tilemap.tiles.WaterTileFactory;
import com.badlogic.gdx.graphics.Texture;

public class WaterLifeZone implements LifeZone {

    private TileFactory waterTileFactory;
    private float minHumidity, maxHumidity;

    public WaterLifeZone(Texture texture) {
        waterTileFactory = new WaterTileFactory(texture);
    }

    @Override
    public void setHumidityBorders(float minHumidity, float maxHumidity) {
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
    }

    @Override
    public boolean humidityIsInsideZone(float humidity) {
        return humidity >= minHumidity && humidity <= maxHumidity;
    }

    @Override
    public TileFactory getGroundTileFactory() {
        return waterTileFactory;
    }
}
