package ch.travbit.exploring.world.tilemap.tiles;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.VisualComponent;
import ch.travbit.exploring.util.rendering.RenderLayer;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WaterTileFactory implements TileFactory {

    private Texture texture;
    private Color color;

    public WaterTileFactory(Texture texture) {
        this.texture = texture;
        color = Color.BLUE;
    }

    @Override
    public void addTileToEngine(PooledEngine engine, int tileX, int tileY) {
        PositionComponent pos = new PositionComponent(tileX, tileY);
        VisualComponent visual = new VisualComponent(new TextureRegion(texture), color, RenderLayer.TILE.getIndex());
        Entity tile = engine.createEntity();
        tile.add(pos);
        tile.add(visual);
        engine.addEntity(tile);
    }
}
