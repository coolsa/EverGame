package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

public abstract class DieableEntity implements LevelAspect {
	private static final float FULL_HP_COEF = 0.8f;
	private static final float MEDIUM_HP_COEF = 0.5f;
	
	private volatile boolean isDead;
    protected float currentHP;
    protected float maxHP;
    protected Body aliveBody;
    protected Body deadBody;
    protected String type;
    protected Level l;
	
	public DieableEntity() {
		
	}

	public DieableEntity(boolean dead, float currentHP, float maxHP, Body aliveBody, Body deadBody, String type, Level l)
    {
        this.isDead = dead;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.aliveBody = aliveBody;
        this.deadBody = deadBody;
        this.type = type; 
        this.l = l;
    }

	@Override
	public void create_level();

	@Override
	public String item();

    public void setLevel(Level l)
    {
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
	
	protected void setAliveSprite(Sprite aliveSprite) {
		this.aliveSprite = aliveSprite;
	}

	protected void setDeadSprite(Sprite deadSprite) {
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

	protected void setDeadBody(Body deadBody) {
		this.deadBody = deadBody;
	}
}
