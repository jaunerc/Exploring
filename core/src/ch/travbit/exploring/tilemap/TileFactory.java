package ch.travbit.exploring.tilemap;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TileFactory {

    private static final int TILE_WIDTH = 32;
    private static final int TILE_HEIGHT = 32;

    public static void addSimpleTile(PooledEngine engine, int x, int y) {
        Entity tile = engine.createEntity();
        tile.add(new PositionComponent(x * TILE_WIDTH, y * TILE_HEIGHT));
        tile.add(new VisualComponent(new TextureRegion(new Texture("assets/tiles/grass.png"))));
        engine.addEntity(tile);
    }
}
