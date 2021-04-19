package pp.game.audio;

import pp.game.level.ILevel;
import pp.game.level.LevelMaker;

public class EndGame extends GameMusicType
{
    public EndGame() {
		super("music/game/end_game.ogg");
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
}