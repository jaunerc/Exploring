package ch.travbit.exploring.world.map;

import ch.travbit.exploring.util.AssetLoader;

/**
 * This class is a facade to create map factories.
 */
public final class TileMapFacade {

    private TileMapFacade() {}

    public static MapFactory createExploringMapFactory(AssetLoader assetLoader) {
        MapFactory mapFactory = new ExploringMapFactory(assetLoader);
        return mapFactory;
    }
}
