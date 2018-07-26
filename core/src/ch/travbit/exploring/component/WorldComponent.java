package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class WorldComponent implements Component, Pool.Poolable {

    public int temperatureSeed;

    public WorldComponent(int temperatureSeed) {
        this.temperatureSeed = temperatureSeed;
    }

    @Override
    public void reset() {
        temperatureSeed = 0;
    }
}
