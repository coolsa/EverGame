package pp.game.textures;

import pp.game.level.LevelMaker;

public class BackgroundFour extends BackgroundTextureType
{
    public BackgroundFour()
    {
        super("textures/background/base_3.png", 256, 256);
    }

//    private BackgroundFour(Level l)
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

    @Override
    public LevelMaker maker()
    {
        return null;
//        l.setBackgroundTextureType(this);
    }

}