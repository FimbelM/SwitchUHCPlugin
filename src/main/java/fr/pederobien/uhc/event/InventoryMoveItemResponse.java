package fr.pederobien.uhc.event;

import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InventoryMoveItemResponse extends EventResponse<InventoryMoveItemEvent> {
	private boolean canDropItem, blockForbidden, blockAlreadyDropped, cannotGetItemBack;

	protected InventoryMoveItemResponse(InventoryMoveItemEvent event, boolean canDropItem, boolean blockForbidden, boolean blockAlreadyDropped,
			boolean cannotGetItemBack) {
		super(event);
		this.canDropItem = canDropItem;
		this.blockForbidden = blockForbidden;
		this.blockAlreadyDropped = blockAlreadyDropped;
		this.cannotGetItemBack = cannotGetItemBack;
	}

	public boolean canDropItem() {
		return canDropItem;
	}

	public boolean isBlockAlreadyDropped() {
		return blockAlreadyDropped;
	}

	public boolean isBlockForbidden() {
		return blockForbidden;
	}

	public boolean cannortGetItemBack() {
		return cannotGetItemBack;
	}
}
