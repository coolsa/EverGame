package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.Game;
import pp.game.handlers.level.BasicLevelHandler;
import pp.game.level.*;
import pp.game.textures.MonsterDeathTextureType;
import pp.game.textures.MonsterWalkTextureType;
import pp.game.textures.SingleTiledTextureType;
import pp.game.textures.TextureHolder;
import pp.game.utils.type.TypeConverter;

import com.badlogic.gdx.physics.box2d.*;

import java.util.logging.Level;

public class Spider extends MonsterType {

    public Spider() {
        //Todo: put the animatedSprite creation in the dieable type!
        super(false, 150, 150, null, null, "SPIDER", null,
                150, 0.33f, 10,
                0.75f, 15);
    }

    @Override
    public String item() {
        return type;
    }
}