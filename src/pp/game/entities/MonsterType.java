package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

public class MonsterType extends DieableEntity {
	private float HP;
	private float walkSpeed;
	private float damage;
	private float attackSpeed;		// in seconds
	private int scorePoints;
    private String spawnIntervals;
    private String spawnIntervalDecrements;

    private MonsterType(boolean dead, float currentHP, float maxHP, Body aliveBody, Body deadBody, String type, Level l, 
            float hP, float walkSpeed, float damage,
			float attackSpeed, int scorePoints, String interval, String intervalDec) {
        super(dead, currentHP, maxHP, aliveBody, deadBody, type, l);
		HP = hP;
		this.walkSpeed = walkSpeed;
		this.damage = damage;
		this.attackSpeed = attackSpeed;
		this.scorePoints = scorePoints;
        spawnIntervals = interval;
        spawnIntervalDecrements = intervalDec;
	}
	@Override
    public abstract create_level()
	{
		l.setMonsterTypes(this.type);
        l.setSpawnInterval(this.spawnIntervals);
        l.setSpawnIntervalDec(this.spawnIntervalDecrements);
	}
	@Override
	public String item()
	{
		return type;
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

    public String get spawnIntervalDec()
    {
        return spawnIntervalDecrements;
    }

    public void setLevel(Level l)
    {
        this.l = l;
    }
}