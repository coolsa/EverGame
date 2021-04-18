package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

public class Player extends DieableEntity
{
    private static final Player INSTANCE = new Player();
    private float speed;
    private Weapon weapon;

    private Player(boolean dead, float currentHP, float maxHP, Body aliveBody, Body deadBody, String type, Level l, float s, Weapon w)
    {
        super(daed, currentHP, maxHP, aliveBody, deadBody, type, l);
        speed = s;
        weapon = w;
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
			scene.detachChild(this.weapon.getSprite());
			newWeapon.setWeaponBonus(weapon.getWeaponBonus());
		}
		this.weapon = newWeapon;
		scene.attachChild(SceneLayoutUtils.adjustWeapon(newWeapon).getSprite());
	}

    public Weapon getWeapon() {
		return weapon;
	}

    public float getPlayerSpeed() {
		return playerSpeed;
	}

	public void setPlayerSpeed(float playerSpeed) {
		this.playerSpeed = playerSpeed;
	}

	public void setLevel(Level l)
    {
        this.l = l;
    }

    @Override
    public void create_level()
    {
        l.setInitialPlayerHP(this.currentHP);
        l.setMaxHP(this.maxHP);
    }
}