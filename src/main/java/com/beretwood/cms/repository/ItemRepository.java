package com.beretwood.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beretwood.cms.order.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
