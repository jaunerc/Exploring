package ch.travbit.exploring.tilemap;

import ch.travbit.exploring.util.AssetLoader;

public final class TileMapFacade {

    private TileMapFacade() {}

    public static MapFactory createSimpleMapFactory(AssetLoader assetLoader) {
        MapFactory mapFactory = new SimpleMapFactory(assetLoader);
        return mapFactory;
    }
}
