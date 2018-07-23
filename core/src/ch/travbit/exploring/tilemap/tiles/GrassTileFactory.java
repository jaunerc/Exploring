package ch.travbit.exploring.tilemap.tiles;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GrassTileFactory implements TileFactory {

    private int tileWidth;
    private int tileHeight;
    private Color color;

    public GrassTileFactory(int tileWidth, int tileHeight) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        color = Color.GREEN;
    }

    @Override
    public void addTileToEngine(PooledEngine engine, int tileX, int tileY) {
        PositionComponent pos = new PositionComponent(tileX * tileWidth, tileY * tileHeight);
        VisualComponent visual = new VisualComponent(new TextureRegion(new Texture("assets/tiles/grass.png")), color);
        Entity tile = engine.createEntity();
        tile.add(pos);
        tile.add(visual);
        engine.addEntity(tile);
    }
}
