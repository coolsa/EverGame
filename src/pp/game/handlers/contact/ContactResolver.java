package pp.game.handlers.contact;

import pp.game.audio.*;
import pp.game.entities.*;
import pp.game.physics.*;
import pp.game.utils.type.*;

public class ContactResolver {
	private ContactResolver() {
		
	}

	public static IContactHandler getPlayerMonsterContactHandler(MonsterType monster) {
		return new PlayerMonsterContactUpdateHandler(monster);
	}

	public static void handleBulletMonsterContact(Bullet bullet, MonsterType monster) {
		monster.adjustCurrentHP(-bullet.getDamage());
		AudioHolder.getInstance().playEntityHitSound(
				TypeConverter.getEntityHitSoundType(monster));
		PhysicsManager.getInstance().removeBody(bullet.getBody());
	}
	
	public static void handleBonusPlayerContact(Bonus bonus) {
		final Player player = Player.getInstance();
		if (player.isDead()) {
			return;
		}
		
		BonusManager.getInstance().onBonusPick(bonus.getBonusType());
		PhysicsManager.getInstance().removeBody(bonus.getBody());
	}
}
