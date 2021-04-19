package pp.game.textures;

import pp.game.level.LevelAspect;
import pp.game.level.LevelMaker;

public class BackgroundOne extends BackgroundTextureType
{

    public BackgroundOne()
    {
        super("textures/background/base_0.png", 256, 256);
    }

    public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

//    public void setLevel(Level l)
//    {
//        this.l = l;
//    }

}