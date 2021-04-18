package pp.game.textures;

public class BackgroundOne extends BackgroundTextureType
{
    private BackgroundOne(String assetPath, float width, float height)
    {
        super(assetPath, width, height);
    }

    @Override
    public LevelAspect create_level()
    {
        l.setBackgroundTextureType(this.assetPath);
    }

    @Override
    public String item()
    {
        return assetPath;
    }

    private BackgroundOne(Level l)
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

}