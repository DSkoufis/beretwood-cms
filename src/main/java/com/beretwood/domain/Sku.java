package com.beretwood.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sku")
public class Sku {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "code", unique = true, updatable = false, length = 20, nullable = false)
	private String code;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "price", precision = 2)
	private Double price;

	@Column(name = "weight", precision = 1)
	private Float weight;

	public Sku() {
	}

	public Sku(String code, int quantity, Double price) {
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
}
