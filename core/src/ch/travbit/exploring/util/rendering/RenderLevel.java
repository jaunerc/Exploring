package ch.travbit.exploring.util.rendering;

public enum RenderLevel {
    PLAYER(0), TILE(1);

    int z;

    RenderLevel(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }
}
