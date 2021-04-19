package pp.game.audio;

import pp.game.level.ILevel;
import pp.game.level.LevelMaker;

public class LowHP extends GameMusicType
{
    public LowHP() {
		super("music/game/low_hp.ogg");
	}
	
	public String getAssetPath() {
		return assetPath;
	}

    @Override
    public LevelMaker maker() {
        return null;
    }

//    public void setLevel(ILevel l)
//    {
//        this.l = l;
//    }

//    @Override
//    public void create_level()
//    {
//        l.setMusic(this.assetPath);
//    }
}