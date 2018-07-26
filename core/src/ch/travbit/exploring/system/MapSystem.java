package ch.travbit.exploring.system;

import ch.travbit.exploring.component.PlayerComponent;
import ch.travbit.exploring.component.PositionComponent;
import ch.travbit.exploring.world.World;
import ch.travbit.exploring.world.tilemap.MapFactory;
import ch.travbit.exploring.world.tilemap.TileMapFacade;
import ch.travbit.exploring.util.AssetLoader;
import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;

public class MapSystem extends IteratingSystem {

    private ComponentMapper<PositionComponent> pm;
    private World world;

    public MapSystem(World world) {
        super(Family.all(PlayerComponent.class, PositionComponent.class).get());

        this.world = world;
        pm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        if (position.vector.x > 50) {
            PooledEngine engine = (PooledEngine) getEngine();
            //ToDo world expanding
        }
    }
}
