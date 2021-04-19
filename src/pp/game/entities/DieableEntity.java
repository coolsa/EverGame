package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.Game;
import pp.game.handlers.level.BasicLevelHandler;
import pp.game.level.*;
import pp.game.textures.MonsterDeathTextureType;
import pp.game.textures.MonsterWalkTextureType;
import pp.game.textures.TextureHolder;

import com.badlogic.gdx.physics.box2d.*;

public abstract class DieableEntity implements LevelAspect {
    public enum HPState {
        DEAD, LOW, MEDIUM, HIGH;
    }

    private static final float FULL_HP_COEF = 0.8f;
    private static final float MEDIUM_HP_COEF = 0.5f;

    private volatile boolean isDead;
    protected float currentHP;
    protected float maxHP;
    protected Body aliveBody;
    protected Body deadBody;
    protected HPState hpState;
    protected AnimatedSprite aliveSprite;
    protected AnimatedSprite deadSprite;

    protected String type;
    protected BasicLevelHandler l;

    public DieableEntity(boolean dead, float currentHP, float maxHP, Body aliveBody, Body deadBody, String type, BasicLevelHandler l) {
        this.isDead = dead;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.aliveBody = aliveBody;
        this.deadBody = deadBody;
        this.aliveSprite = new AnimatedSprite(0, 0, TextureHolder.getInstance().getTiledTexture(
                MonsterWalkTextureType.valueOf(type)), Game.getGameActivity().getVertexBufferObjectManager());
        this.deadSprite = new AnimatedSprite(0, 0, TextureHolder.getInstance().getTiledTexture(
                MonsterDeathTextureType.valueOf(type)), Game.getGameActivity().getVertexBufferObjectManager());
        this.type = type;
        this.l = l;
    }

//    public DieableEntity() {
//        this.isDead = isDead;
//        this.currentHP = currentHP;
//        this.maxHP = maxHP;
//        this.aliveBody = aliveBody;
//        this.deadBody = deadBody;
//        this.aliveSprite = aliveSprite;
//        this.deadSprite = deadSprite;
//        this.type = type;
//        this.l = l;
//    }

    @Override
    public LevelMaker maker() {
        return null;
    }

    @Override
    public String item() {
        return type;
    }

    public void setLevel(BasicLevelHandler l) {
        this.l = l;
    }

    protected abstract void die();

    private void adjustHPState() {
        float playerHPCoef = getCurrentHP() / getMaxHP();
        if (playerHPCoef >= FULL_HP_COEF) {
            hpState = HPState.HIGH;
        } else if (playerHPCoef >= MEDIUM_HP_COEF) {
            hpState = HPState.MEDIUM;
        } else if (getCurrentHP() != 0) {
            hpState = HPState.LOW;
        } else {
            hpState = HPState.DEAD;
        }
    }

    public float getCurrentHP() {
        return currentHP;
    }

    public void adjustCurrentHP(float value) {
        this.currentHP += value;
        if (currentHP <= 0) {
            if (!isDead()) {
                die();
            }
            isDead = true;
            currentHP = 0;
        } else if (currentHP > maxHP) {
            currentHP = maxHP;
        }
        adjustHPState();
    }

    public float getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(float maxHP) {
        this.maxHP = maxHP;
        adjustHPState();
    }

    public boolean isDead() {
        return isDead;
    }

    public Sprite getAliveSprite() {
        return aliveSprite;
    }

    public Sprite getDeadSprite() {
        return deadSprite;
    }

    public Body getBody() {
        return isDead() ? getDeadBody() : getAliveBody();
    }

    public Sprite getShape() {
        return isDead() ? getDeadSprite() : getAliveSprite();
    }

    public HPState getHPState() {
        return hpState;
    }

    protected void setIdDead(boolean isDead) {
        this.isDead = isDead;
    }

    protected void setCurrentHP(float currentHP) {
        this.currentHP = currentHP;
        adjustHPState();
    }

    protected void setAliveSprite(AnimatedSprite aliveSprite) {
        this.aliveSprite = aliveSprite;
    }

    protected void setDeadSprite(AnimatedSprite deadSprite) {
        this.deadSprite = deadSprite;
    }


    public Body getAliveBody() {
        return aliveBody;
    }

    protected void setAliveBody(Body aliveBody) {
        this.aliveBody = aliveBody;
    }


    public Body getDeadBody() {
        return deadBody;
    }

    public String getType() {
        return type;
    }

    protected void setDeadBody(Body deadBody) {
        this.deadBody = deadBody;
    }
}
