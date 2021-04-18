package pp.game.textures;

public abstract class BackgroundTextureType implements LevelAspect
{
    protected String assetPath;
    protected float width, height; 
    protected Level l;


    private BackgroundTextureType(String assetPath, float width, float height, Level l) {
		this.assetPath = assetPath;
		this.width = width;
		this.height = height;
        this.l = l;
	}

    @Override
    public void create_level();

    @Override
    public String item();

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
