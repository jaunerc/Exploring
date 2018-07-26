package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.tilemap.MapFactory;
import ch.travbit.exploring.world.tilemap.TileMapFacade;
import ch.travbit.exploring.util.AssetLoader;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;

public class MapSystem extends IteratingSystem {

    private ComponentMapper<PositionComponent> pm;
    private World world;
    private Vector2 currentChunkPos;

    public MapSystem(World world) {
        super(Family.all(PlayerComponent.class, PositionComponent.class).get());

        this.world = world;
        currentChunkPos = new Vector2();
        pm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        world.expandWorld(position.vector);
    }
}
