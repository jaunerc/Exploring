package ch.travbit.exploring.tilemap;

import com.badlogic.ashley.core.PooledEngine;

public class MapFactory {

    public static void createMapInEngine(PooledEngine engine, int mapWidth, int mapHeight) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                TileFactory.addSimpleTile(engine, i, j);
            }
        }
    }
}
