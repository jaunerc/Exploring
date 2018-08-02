package ch.travbit.exploring.world.tilemap;

import ch.travbit.exploring.util.AssetLoader;

/**
 * This class is a facade to create map factories.
 */
public final class TileMapFacade {

    private TileMapFacade() {}

    public static MapFactory createSimpleMapFactory(AssetLoader assetLoader) {
        MapFactory mapFactory = new SimpleMapFactory(assetLoader);
        return mapFactory;
    }

    public static MapFactory createExploringMapFactory(AssetLoader assetLoader) {
        MapFactory mapFactory = new ExploringMapFactory(assetLoader);
        return mapFactory;
    }
}
