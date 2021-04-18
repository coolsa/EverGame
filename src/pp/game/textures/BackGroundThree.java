package pp.game.textures;

public class BackgroundThree extends BackgroundTextureType
{
    private BackgroundThree(String assetPath, float width, float height)
    {
        super(assetPath, width, height);
    }

    private BackgroundThree(Level l)
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