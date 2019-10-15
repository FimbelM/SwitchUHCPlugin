package fr.pederobien.uhc.world.blocks;

public interface IBase extends IBawn, IUnmodifiableBase {
	public static final IBase DEFAULT = new Base("DefaultBase");
}
