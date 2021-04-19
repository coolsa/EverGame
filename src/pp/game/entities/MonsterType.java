package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.handlers.level.BasicLevelHandler;
import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

import java.util.logging.Level;

public class MonsterType extends DieableEntity {
	private float HP;
	private float walkSpeed;
	private float damage;
	private float attackSpeed;		// in seconds
	private int scorePoints;
    private String spawnIntervals;
    private String spawnIntervalDecrements;

    public MonsterType(boolean dead, float currentHP, float maxHP, Body aliveBody, Body deadBody, String type, BasicLevelHandler l,
					   float hP, float walkSpeed, float damage,
					   float attackSpeed, int scorePoints) {
        super(dead, currentHP, maxHP, aliveBody, deadBody, type, l);
		HP = hP;
		this.walkSpeed = walkSpeed;
		this.damage = damage;
		this.attackSpeed = attackSpeed;
		this.scorePoints = scorePoints;
        spawnIntervals = "monsters.spawn.interval";
        spawnIntervalDecrements = "monsters.spawn.interval.decrement";
	}

	@Override
    public LevelMaker maker()
	{
		return null;
	}

	@Override
	public String item()
	{
		return type;
	}

	@Override
	protected void die() {
    	//not needed for monsters.
	}

	public float getHP() {
		return HP;
	}

	public float getWalkSpeed() {
		return walkSpeed;
	}

	public float getDamage() {
		return damage;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

	public int getScorePoints() {
		return scorePoints;
	}

    public String getSpawnInterval()
    {
        return spawnIntervals;
    }

    public String getSpawnIntervalDecrement()
    {
        return spawnIntervalDecrements;
    }

    public void setLevel(BasicLevelHandler l)
    {
        this.l = l;
    }

    public Sprite getAliveSprite(){
    	return this.aliveSprite;
	}
}