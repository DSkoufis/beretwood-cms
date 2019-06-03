package com.beretwood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToMany
	@JoinTable(name = "orders_items", joinColumns = {@JoinColumn(name = "order_id")}, inverseJoinColumns = {@JoinColumn(name = "item_id")})
	private List<Sku> items;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client recipient;

	public Order() {
	}

	public Order(Client recipient) {
		this.recipient = recipient;
	}

	public Long getId() {
		return id;
	}

	public List<Sku> getItems() {
		return items;
	}

	public void setItems(Collection<Sku> items) {
		for (Sku item : items) {
			this.setItem(item);
		}
	}

	public void setItem(Sku item) {
		this.items.add(item);
	}

	public Client getRecipient() {
		return recipient;
	}

	public void setRecipient(Client recipient) {
		this.recipient = recipient;
	}
}
