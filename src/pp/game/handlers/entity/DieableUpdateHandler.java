package pp.game.handlers.entity;

import pp.game.entities.*;
import pp.game.handlers.*;

public abstract class DieableUpdateHandler extends UpdateHandler {
	private DieableEntity[] entities;
	private IHandlerCommand[] commands;
	private boolean executed = false;
	
	public DieableUpdateHandler() {
		this(new DieableEntity[0], new IHandlerCommand[0]);
	}
	
	public DieableUpdateHandler(DieableEntity[] entities) {
		this(entities, new IHandlerCommand[0]);
	}
	
	public DieableUpdateHandler(DieableEntity[] entities, IHandlerCommand[] commands) {
		this.entities = entities;
		this.commands = commands;
	}
	
	protected void setEntities(DieableEntity...entities) {
		this.entities = entities;
	}
	
	protected void setCommands(IHandlerCommand...commands) {
		this.commands = commands;
	}
	
	@Override
	final public void onUpdate(float secondsElapsed) {
		for (DieableEntity entity : entities) {
			if (entity.isDead()) {
				if (!executed) {
					for (IHandlerCommand command : commands) {
						command.execute();
					}
				}
				executed = true;
				return;
			}
		}
		onUpdate();
	}
	
	protected abstract void onUpdate();
}
