package com.beretwood.cms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beretwood.cms.order.Item;
import com.beretwood.cms.repository.ItemRepository;

@SpringBootTest
class ItemServiceIntegrationTest {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;

	@Test
	void createItem_ifItemExistsExceptionThrown() {
		String id = "SKU-1";

		itemService.createItem(id);
		itemService.createItem(id);

		List<Item> items = itemRepository.findAll();
		assertEquals(1, items.size());
	}
}
