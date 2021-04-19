package pp.game.level;

import java.io.*;
import java.util.*;

import pp.game.*;
import pp.game.audio.*;
import pp.game.entities.*;
import pp.game.handlers.level.BasicLevelHandler;
import pp.game.handlers.level.ILevelHandler;
import pp.game.textures.*;
import android.util.*;

public class ConfigLevelInitializer implements LevelMaker {
private static final String SEPARATOR = ",";
	
//	private static final String BACKGROUND;
//	private static final String MUSIC;
//	private static final String PLAYER_HP_INITIAL;
//	private static final String PLAYER_HP_MAX;
//	private static final String MONSTERS_TYPES;
//	private static final String MONSTERS_SPAWN_INTERVALS;
//	private static final String MONSTERS_SPAWN_INTERVAL_DECREMENTS;
	
	private Properties props;
	private DieableEntity de;
    private BackgroundTextureType bt;
	private GameMusicType gm;

	public ConfigLevelInitializer(ConfigLevelType type){
//		super(type);
	}

	public ConfigLevelInitializer(ConfigLevelType type, DieableEntity de, BackgroundTextureType bt, GameMusicType gm) {
		this.de = de;
		this.bt = bt;
		this.gm = gm;
		props = new Properties();
		try {
			props.load(Game.getGameActivity().getAssets().open(type.getAssetPath()));
		} catch (IOException e) {
			Log.e("", "Error creating level " + type, e);
		}
	}

//	public void setMusic(String s)
//	{
//		music = s;
//	}
//
//	public void setBackgroundTextureType(String s)
//	{
//		background = s;
//	}
//
//	public void setMonsterTypes(String s)
//	{
//		monster_types = s;
//	}
//
//	public void setSpawnInterval(String s)
//	{
//		monsters_spawn_intervals = s;
//	}
//
//	public void setSpawnIntervalDec(String s)
//	{
//		spawnIntervalDecrements = s;
//	}
//
//	public void setPlayerHpInitial(String s)
//	{
//		player_hp_initial = s;
//	}
//
//	public void setPlayerHPMax(String s)
//	{
//		player_hp_max = s;
//	}

	@Override
	public void create_level() {
		BasicLevel level = new BasicLevel();
		level.setGameMusicType(getGameMusicType());
		level.setInitialPlayerHP(getInitialPlayerHP());
		level.setMaxPlayerHP(getMaxPlayerHP());
	}
	
	private float[] convertToFloat(String property) {
		String value = props.getProperty(property);
		if (value == null) {
			return new float[0];
		}
		
		String[] valuesStr = value.split(SEPARATOR);
		float[] valuesFloat = new float[valuesStr.length];
		for (int i = 0; i < valuesFloat.length; i++) {
			valuesFloat[i] = Float.valueOf(valuesStr[i]);
		}
		return valuesFloat;
	}
	
	private MonsterType[] convertToMonsterType(String property) {
		String value = props.getProperty(property);
		if (value == null) {
			return new MonsterType[0];
		}
		
		String[] valuesStr = value.split(SEPARATOR);
		MonsterType[] valuesMonsterType = new MonsterType[valuesStr.length];
		for (int i = 0; i < valuesMonsterType.length; i++) {
//			valuesMonsterType[i] = MonsterType.valueOf(valuesStr[i]);
		}
		return valuesMonsterType;
	}
	
	private GameMusicType getGameMusicType() {
		return this.gm;
	}

	private float[] getSpawnIntervals() {
		return convertToFloat("monsters.spawn.interval");
	}

	private float[] getSpawnIntervalsDecrements() {
		return convertToFloat("monsters.spawn.interval.decrement");
	}

	private MonsterType[] getMonstersTypes() {
		return convertToMonsterType("monsters.types");
	}

	private BackgroundTextureType getBackground() {
		return this.bt;
	}
	
	private float getInitialPlayerHP() {
		String hp = props.getProperty("player.hp.initial");
		return hp == null ? 0 : Float.valueOf(hp);
	}
	
	private float getMaxPlayerHP() {
		String hp = props.getProperty("player.hp.max");
		return hp == null ? 0 : Float.valueOf(hp);
	}

	public ILevelHandler getLevelHandler() {
		return new BasicLevelHandler(getMonstersTypes(),
				getSpawnIntervals(), getSpawnIntervalsDecrements());
	}

	public ILevel getLevel() {
		BasicLevel level = new BasicLevel();
		level.setBackgroundTextureType(getBackground());
		level.setGameMusicType(getGameMusicType());
		level.setInitialPlayerHP(getInitialPlayerHP());
		level.setMaxPlayerHP(getMaxPlayerHP());
		return level;
	}
}
