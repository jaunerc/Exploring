package ch.travbit.exploring.world.tilemap.tiles;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.TileComponent;
import ch.travbit.exploring.component.VisualComponent;
import ch.travbit.exploring.util.TileAsset;
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
        PositionComponent pos = engine.createComponent(PositionComponent.class);
        pos.vector.x = tileX;
        pos.vector.y = tileY;
        VisualComponent visual = engine.createComponent(VisualComponent.class);
        visual.textureRegion = new TextureRegion(texture);
        visual.color = color;
        visual.renderLevel = RenderLayer.TILE.getIndex();
        TileComponent tileComponent = engine.createComponent(TileComponent.class);
        tileComponent.tileAsset = TileAsset.TILE_WATER;
        Entity tile = engine.createEntity();
        tile.add(pos);
        tile.add(visual);
        tile.add(tileComponent);
        engine.addEntity(tile);
    }
}
