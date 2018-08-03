package ch.travbit.exploring.world.climate;

import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.component.TileComponent;
import ch.travbit.exploring.component.VisualComponent;
import ch.travbit.exploring.util.rendering.RenderLayer;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This class represents a basic tile factory.
 */
public abstract class BaseTileFactory implements TileFactory {

    private Texture texture;
    private Color color;

    public BaseTileFactory(Texture texture, Color color) {
        this.texture = texture;
        this.color = color;
    }

    @Override
    public void addTileToEngine(PooledEngine engine, int tileX, int tileY) {
        PositionComponent pos = engine.createComponent(PositionComponent.class);
        VisualComponent visual = engine.createComponent(VisualComponent.class);
        TileComponent tileComponent = engine.createComponent(TileComponent.class);
        Entity tile = engine.createEntity();

        pos.vector.x = tileX;
        pos.vector.y = tileY;
        visual.textureRegion = new TextureRegion(texture);
        visual.color = color;
        visual.renderLevel = RenderLayer.TILE.getIndex();
        tile.add(pos);
        tile.add(visual);
        tile.add(tileComponent);
        engine.addEntity(tile);
    }
}
