package pp.game.audio;

import pp.game.level.ILevel;
import pp.game.level.LevelMaker;

public class MusicOne extends GameMusicType
{
    public MusicOne() {
		super("music/game/base_0.ogg");
	}
	
	public String getAssetPath() {
		return assetPath;
	}

    public void setLevel(ILevel l)
    {
        this.l = l;
    }

    @Override
    public LevelMaker maker() {
        return null;
    }

//    @Override
//    public void create_level()
//    {
//        l.setMusic(this.assetPath);
//    }
//
//    @Override
//    public String item()
//    {
//        return assetPath;
//    }
}