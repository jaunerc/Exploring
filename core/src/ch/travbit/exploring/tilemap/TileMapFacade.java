package ch.travbit.exploring.tilemap;

public final class TileMapFacade {

    private TileMapFacade() {}

    public static MapFactory createSimpleMapFactory() {
        MapFactory mapFactory = new SimpleMapFactory();
        return mapFactory;
    }
}
