package pp.game.audio;

import pp.game.level.ILevel;
import pp.game.level.LevelMaker;

public class MusicThree extends GameMusicType
{
    public MusicThree() {
		super("music/game/base_2.ogg");
	}
	
	public String getAssetPath() {
		return assetPath;
	}

    public void setLevel(ILevel l)
    {
//        l.setMusic(this.assetPath);
        this.l = l;
    }

    @Override
    public LevelMaker maker() {
        return null;
    }

//    @Override
//    public void create_level()
//    {
//    }
}