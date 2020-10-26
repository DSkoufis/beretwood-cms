package com.beretwood.cms.order;

public class Order {

	private Long id;
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
