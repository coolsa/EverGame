package pp.game.audio;

import org.andengine.entity.sprite.*;

import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

public abstract class GameMusicType implements LevelAspect
{
    protected String assetPath;
    protected Level l;

    private GameMusicType(String assetPath, Level l) {
		this.assetPath = assetPath;
        this.l = l;
	}
	
	public String getAssetPath() {
		return assetPath;
	}

    @Override
    public void create_level();

    @Override
    public String item(); 

}