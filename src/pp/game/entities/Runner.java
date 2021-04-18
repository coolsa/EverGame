package pp.game.entities;

import org.andengine.entity.sprite.*;

import pp.game.level.*;

import com.badlogic.gdx.physics.box2d.*;

public class Runner extends MonsterType{

    public Runner(boolean dead, float currentHP, float maxHP, Body aliveBody, Body deadBody, String type, Level l, 
    float hP, float walkSpeed, float damage,
    float attackSpeed, int scorePoints, String interval, String intervalDec){
        super(dead, currentHP, maxHP, aliveBody, deadBody, type, l, attackSpeed, scorePoints, interval, intervalDec);
    }

	@Override
    public void create_level()
    {
        l.setMonsterTypes(this.type);
        l.setSpawnInterval(this.spawnIntervals);
        l.setSpawnIntervalDec(this.spawnIntervalDecrements);
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

}