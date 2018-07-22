package ch.travbit.exploring.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

public class B2dBodyComponent implements Component {
    private Body body;

    public B2dBodyComponent(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }
}
