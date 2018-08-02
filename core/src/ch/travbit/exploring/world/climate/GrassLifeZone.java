package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.world.tilemap.tiles.GrassTileFactory;
import ch.travbit.exploring.world.tilemap.tiles.TileFactory;
import com.badlogic.gdx.graphics.Texture;

public class GrassLifeZone implements LifeZone {
    private TileFactory grassTileFactory;
    private float minHumidity, maxHumidity;

    public GrassLifeZone(Texture texture) {
        grassTileFactory = new GrassTileFactory(texture);
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
        return grassTileFactory;
    }
}
