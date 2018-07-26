package ch.travbit.exploring.world;

import com.badlogic.gdx.math.Vector2;

import java.util.Objects;

public final class ChunkPos {

    private int x;
    private int y;

    public ChunkPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChunkPos chunkPos = (ChunkPos) o;
        return getX() == chunkPos.getX() &&
                getY() == chunkPos.getY();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getX(), getY());
    }
}
