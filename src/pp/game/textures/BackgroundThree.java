package pp.game.textures;

import pp.game.level.LevelMaker;

public class BackgroundThree extends BackgroundTextureType
{
    public BackgroundThree()
    {
        super("textures/background/base_2.png", 256, 256);
    }

//    private BackgroundThree(Level l)
//    {
//        super(l);
//    }

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