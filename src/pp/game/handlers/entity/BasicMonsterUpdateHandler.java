package pp.game.handlers.entity;

import org.andengine.entity.sprite.*;

import pp.game.entities.*;
import pp.game.handlers.*;
import pp.game.textures.*;
import pp.game.utils.*;
import pp.game.utils.geometry.*;
import pp.game.utils.type.*;

public class BasicMonsterUpdateHandler extends DieableUpdateHandler implements IMonsterUpdateHandler {
	private static final float MIN_COORD_DIFF = 20f;
	
	private Player player;
	private MonsterType monster;
	private AnimatedSprite aliveSprite;
	private MonsterWalkTextureType monsterWalkType;
	private long[] durations;
	
	private class BasicMonsterHandlerCommand implements IHandlerCommand {
		public BasicMonsterHandlerCommand() {
			
		}		
		
		@Override
		public void execute() {				
			if (!monster.isDead()) {				
				Point reverseDirection = GeometryUtils.convertToDirection(
							new Point(aliveSprite.getX(), aliveSprite.getY()), 
							new Point(player.getShape().getX(), player.getShape().getY()));
				Point direction = new Point(-reverseDirection.x, -reverseDirection.y);
				monster.getAliveSprite().setRotation(monster.getAliveSprite().getRotation() + 180);
				animateAndRun(direction);
			}
		}
	}
	
	public BasicMonsterUpdateHandler(MonsterType monster) {
		setEntities(monster, Player.getInstance());
		setCommands(new BasicMonsterHandlerCommand());
		
		this.monster = monster;
		aliveSprite = (AnimatedSprite) monster.getAliveSprite();
		player = Player.getInstance();
		
		monsterWalkType = TypeConverter.getMonsterWalkTextureType(monster);
		durations = new long[monsterWalkType.getTilesCount()];
		for (int i = 0; i < durations.length; i++) {
			durations[i] = monsterWalkType.getAnimationDuration();
		}
	}
	
	private void animateAndRun(final Point direction) {
		if (!((AnimatedSprite)monster.getAliveSprite()).isAnimationRunning()) {
			((AnimatedSprite)monster.getAliveSprite()).animate(durations, true);
		}
		monster.getBody().setLinearVelocity(monster.getWalkSpeed()
				* direction.x, monster.getWalkSpeed() * direction.y);
	}
	
	@Override
	protected void onUpdate() {
		Point diffAbs = new Point();
		Point direction = GeometryUtils.convertToDirection(
				new Point(aliveSprite.getX(), aliveSprite.getY()), 
				new Point(player.getShape().getX(), player.getShape().getY()),
				diffAbs);
		aliveSprite.setRotation(GeometryUtils.getRotation(direction));

		if ((diffAbs.x + diffAbs.y) / 2 > MIN_COORD_DIFF) {
			animateAndRun(direction);
		} else {
			((AnimatedSprite)monster.getAliveSprite()).stopAnimation();
			((AnimatedSprite)monster.getAliveSprite()).setCurrentTileIndex(
					CalcUtils.getGreaterOrEqual(monsterWalkType.getStopTiles(),
							((AnimatedSprite)monster.getAliveSprite()).getCurrentTileIndex()));
			monster.getBody().setLinearVelocity(0, 0);
		}
	}
}
