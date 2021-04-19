package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.Game;
import pp.game.audio.AudioHolder;
import pp.game.audio.EndGame;
import pp.game.audio.GameMusicType;
import pp.game.audio.SoundType;
import pp.game.handlers.EndGameHandlersMatcher;
import pp.game.handlers.level.BasicLevelHandler;
import pp.game.level.*;
import pp.game.physics.PhysicsManager;
import pp.game.scene.GameScene;
import pp.game.textures.SingleTextureType;
import pp.game.textures.SingleTiledTextureType;
import pp.game.textures.TextureHolder;
import pp.game.utils.geometry.SceneLayoutUtils;

import com.badlogic.gdx.physics.box2d.*;

public class Player extends DieableEntity {
    private static final Player INSTANCE = new Player(null);
    private float speed;
    private Weapon weapon;
    private AnimatedSprite legsSprite;

    private Player(BasicLevelHandler l) {
        super(false, 0, 0, null, null, "player", l);
        this.getAliveSprite().setAlpha(0);
        speed = SceneLayoutUtils.DEFAULT_PLAYER_SPEED;
        weapon = Weapon.getWeapon(WeaponType.PM);
        legsSprite = new AnimatedSprite(0, 0, TextureHolder.getInstance().getTiledTexture(
                SingleTiledTextureType.PLAYER_WALK), Game.getGameActivity().getVertexBufferObjectManager());
        legsSprite.setCurrentTileIndex(((int[]) ((Object[])
                SingleTiledTextureType.PLAYER_WALK.getUserData())[0])[0]);

    }

    public static Player getInstance() {
        return INSTANCE;
    }

    public void reset() {
        if (!isDead()) {
            PhysicsManager.getInstance().removeBody(getAliveBody());
        }
    }

    public void adjustCurrentHP(float value) {
        super.adjustCurrentHP(value);
    }

    protected void setCurrentHP(float currentHP) {
        super.setCurrentHP(currentHP);
    }

    public void setMaxHP(float maxHP) {
        super.setMaxHP(maxHP);
    }

    public void setWeapon(Weapon newWeapon) {
        if (this.weapon != null) {
            GameScene.getInstance().detachChild(this.weapon.getSprite());
            newWeapon.setWeaponBonus(weapon.getWeaponBonus());
        }
        this.weapon = newWeapon;
        GameScene.getInstance().attachChild(SceneLayoutUtils.adjustWeapon(newWeapon).getSprite());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public float getPlayerSpeed() {
        return this.speed;
    }

    public void setPlayerSpeed(float playerSpeed) {
        this.speed = speed;
    }

    public void setLevel(BasicLevelHandler l) {
        //Todo: find out if this is even useful!
//        l.getInitialPlayerHP();
//        l.getMaxPlayerHP();
//        this.l = l;
    }

    public void die() {
        PhysicsManager.getInstance().removeBody(getAliveBody());
        GameScene.getInstance().detachChild(weapon.getSprite(), false);
        GameScene.getInstance().detachChild(legsSprite);

        GameScene.getInstance().unregisterUpdateHandlers(new EndGameHandlersMatcher());
        GameScene.getInstance().attachChild(getDeadSprite());
        getDeadSprite().setPosition(getAliveSprite());

        Game.getGameActivity().getEngine().getCamera().setChaseEntity(getDeadSprite());
        //TODO: Fix this!
        this.deadSprite.animate(SingleTiledTextureType.PLAYER_DEATH.getAnimationDuration(), false);

        AudioHolder.getInstance().playSound(SoundType.PLAYER_DEATH);
        GameScene.getInstance().setCurrentMusic(new EndGame());

    }

    public AnimatedSprite getLegsSprite() {
        return this.legsSprite;
    }
//    @Override
//    public void create_level() {
//        l.setInitialPlayerHP(this.currentHP);
//        l.setMaxHP(this.maxHP);
//    }
}