package pp.game.audio;

public class MusicTwo extends GameMusicType
{
    private MusicTwo(String assetPath, Level l) {
		super(assetPath, l);
	}
	
	public String getAssetPath() {
		return assetPath;
	}

    public void setLevel(Level l)
    {
        this.l = l;
    }

    @Override
    public void create_level()
    {
        l.setMusic(this.assetPath);
    }

    @Override
    public String item()
    {
        return assetPath;
    }
}