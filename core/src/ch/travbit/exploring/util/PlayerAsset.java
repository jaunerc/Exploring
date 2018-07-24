package ch.travbit.exploring.util;

public enum PlayerAsset {
    PSEUDO("player_pseudo.png");

    private String path;

    PlayerAsset(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
