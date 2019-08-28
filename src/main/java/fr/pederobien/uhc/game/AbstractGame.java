package fr.pederobien.uhc.game;

public abstract class AbstractGame<T extends IGameBaseState> implements IGameBase<T> {

	@Override
	public void start() {
		
	}

	@Override
	public void pause(T before) {
		
	}

	@Override
	public void stop() {
		
	}
}
