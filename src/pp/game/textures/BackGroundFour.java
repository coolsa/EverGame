package pp.game.textures;

public class BackgroundFour extends BackgroundTextureType
{
    private BackgroundFour(String assetPath, float width, float height)
    {
        super(assetPath, width, height);
    }

    private BackgroundFour(Level l)
    {
        super(l);
    }

    public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

    public void setLevel(Level l)
    {
        this.l = l;
    }

    @Override
    public LevelAspect create_level()
    {
        l.setBackgroundTextureType(this);
    }

    @Override
    public String item()
    {
        return assetPath;
    }

}