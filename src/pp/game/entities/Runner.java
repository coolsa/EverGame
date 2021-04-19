package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.Game;
import pp.game.handlers.level.BasicLevelHandler;
import pp.game.level.*;
import pp.game.textures.MonsterDeathTextureType;
import pp.game.textures.MonsterWalkTextureType;
import pp.game.textures.TextureHolder;

import com.badlogic.gdx.physics.box2d.*;

import java.util.logging.Level;

public class Runner extends MonsterType {

    public Runner() {
        super(false, 150, 150, null, null, "RUNNER", null,
                100, 0.50f, 5,
                0.5f, 10);
    }

}