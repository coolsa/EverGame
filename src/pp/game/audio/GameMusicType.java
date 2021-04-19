package pp.game.audio;

import org.andengine.entity.sprite.*;

import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

public abstract class GameMusicType implements LevelAspect
{
    protected String assetPath;
    protected ILevel l;

    public GameMusicType(String assetPath) {
		this.assetPath = assetPath;
	}
	
	public String getAssetPath() {
		return assetPath;
	}


    @Override
    public String item() {
        return assetPath;
    }

}