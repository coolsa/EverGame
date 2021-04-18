package pp.game.textures;

public class BackgroundTwo extends BackgroundTextureType
{
    private BackgroundTwo(String assetPath, float width, float height)
    {
        super(assetPath, width, height);
    }

    private BackgroundTwo(Level l)
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