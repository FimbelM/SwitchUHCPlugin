package fr.martinfimbel.switchuhc.event;

import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickResponse extends BaseEventResponse<InventoryClickEvent> {
	private boolean canDropItem, blockForbidden, blockAlreadyDropped, cannotGetItemBack;

	protected InventoryClickResponse(InventoryClickEvent event, boolean founded, boolean canDropItem, boolean blockForbidden,
			boolean blockAlreadyDropped, boolean cannotGetItemBack) {
		super(event, founded);
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
