package ch.travbit.exploring.tilemap;

import com.badlogic.ashley.core.PooledEngine;

public class OMapFactory {

    public static void createMapInEngine(PooledEngine engine, int mapWidth, int mapHeight) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                OTileFactory.addSimpleTile(engine, i, j);
            }
        }
    }
}
