package com.beretwood.cms.service;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.beretwood.cms.order.Item;
import com.beretwood.cms.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item createItem(String id) {
		id = Objects.requireNonNull(StringUtils.trimToNull(id));
		Item item = new Item();
		item.setId(id);

		return itemRepository.save(item);
	}

}
