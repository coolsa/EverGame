package pp.game.handlers.contact;

import pp.game.audio.*;
import pp.game.entities.*;
import pp.game.handlers.*;
import pp.game.scene.*;

public class PlayerMonsterContactUpdateHandler extends DelayedUpdateHandler implements IContactHandler {
	private MonsterType monster;
	private Player player = Player.getInstance();
	
	public PlayerMonsterContactUpdateHandler(MonsterType monster) {
		this.monster = monster;
		setRequiredDelay(monster.getAttackSpeed());
		hitPlayer();
	}
			
	private void hitPlayer() {
		if (!player.isDead() && !monster.isDead()) {
			if (player.getAliveSprite().collidesWith(monster.getAliveSprite())) {
				player.adjustCurrentHP(-monster.getDamage());
				AudioHolder.getInstance().playEntityHitSound(
						EntityHitSoundType.getRandomPlayerSound());
			} else {
				GameScene.getInstance().unregisterUpdateHandler(this);
			}
		}
	}
	
	@Override
	protected void onUpdate() {
		hitPlayer();
	}
}
