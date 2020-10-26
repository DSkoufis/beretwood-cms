package com.beretwood.cms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.beretwood.cms.order.Item;
import com.beretwood.cms.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

	@Mock
	private ItemRepository itemRepository;

	private ItemService service;

	@BeforeEach
	void setup() {
		service = new ItemServiceImpl(itemRepository);
	}

	@Test
	void createItem_newItemHasCorrectId() {
		String id = "SKU-123";
		Item expected = new Item();
		expected.setId(id);

		when(itemRepository.save(any(Item.class))).thenReturn(expected);

		Item item = service.createItem(id);

		assertEquals(id, item.getId());
	}

	@Test
	void createItem_ifGivenIdIsNullThenExceptionIsThrown() {
		assertThrows(NullPointerException.class, () -> service.createItem(null));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "\n\r", "\t" })
	void createItem_ifGivenIdIsEmptyOrBlankThenExceptionIsThrown(String id) {
		assertThrows(NullPointerException.class, () -> service.createItem(id));
	}

	@Test
	void createItem_savesNewItemToDb() {
		String id = "SKY-123";

		service.createItem(id);

		ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);

		verify(itemRepository).save(itemCaptor.capture());

		Item item = itemCaptor.getValue();
		assertEquals(id, item.getId());
	}

	@ParameterizedTest
	@ValueSource(strings = { "123 ", " 123", " 123 " })
	void createItem_givenIdIsTrimmed(String id) {
		service.createItem(id);

		ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);

		verify(itemRepository).save(itemCaptor.capture());

		Item item = itemCaptor.getValue();
		assertEquals("123", item.getId());
	}

}