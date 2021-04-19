package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.Game;
import pp.game.handlers.level.BasicLevelHandler;
import pp.game.level.*;
import pp.game.textures.MonsterDeathTextureType;
import pp.game.textures.MonsterWalkTextureType;
import pp.game.textures.TextureHolder;

import com.badlogic.gdx.physics.box2d.*;

public class Zombie extends MonsterType {

    public Zombie() {
        super(false, 150, 150, null, null, "ZOMBIE", null,
                250, 0.17f, 15,
                0.75f, 25);
    }

}