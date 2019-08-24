package fr.pederobien.uhc.game;

public abstract class AbstractState implements IGameState {
	protected IGame game;
	
	public AbstractState(IGame game) {
		this.game = game;
	}
	
	@Override
	public void initiate() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void start() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void pause() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void relaunched() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void stop() {
		throw new GameStateException("This method cannot be called by this state");
	}
}
