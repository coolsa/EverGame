package pp.game.textures;

import pp.game.level.ILevel;
import pp.game.level.LevelAspect;
import pp.game.level.LevelMaker;

public abstract class BackgroundTextureType implements LevelAspect {
    protected String assetPath;
    protected float width, height;

    public BackgroundTextureType(String assetPath, float width, float height) {
        this.assetPath = assetPath;
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public LevelMaker maker() {
        return null;
    }

    @Override
    public String item() {
        return assetPath;
    }


    public String getAssetPath(){
        return this.assetPath;
    }
}
