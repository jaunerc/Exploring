package ch.travbit.exploring.component;

import ch.travbit.exploring.util.TileAsset;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public class TileComponent implements Component, Pool.Poolable {
    public TileAsset tileAsset = TileAsset.TILE_WATER;

    @Override
    public void reset() {
        tileAsset = TileAsset.TILE_WATER;
    }
}
