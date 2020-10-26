package com.beretwood.cms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beretwood.cms.order.Order;
import com.beretwood.cms.order.Item;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	private OrderController controller;

	@BeforeEach
	void setup() {
		controller = new OrderController();
	}

	@Test
	void createOrder_getsNewOrderForGivenItem() {
		String id = "AE-123";
		Item item = new Item();
		item.setId(id);

		CreateOrderRequest request = new CreateOrderRequest();
		request.setItemId(id);

		Order order = controller.createOrder(request);

		assertEquals(id, order.getItem().getId());
	}

}
