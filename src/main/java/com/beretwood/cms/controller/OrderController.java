package com.beretwood.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beretwood.cms.order.Order;
import com.beretwood.cms.order.Item;

@RestController
public class OrderController {

	@PostMapping("/create")
	public Order createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
		Item item = new Item();
		item.setId(createOrderRequest.getItemId());

		Order order = new Order();
		order.setItem(item);
		return order;
	}
}
