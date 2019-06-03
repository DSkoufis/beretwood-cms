package com.beretwood.dao;

import com.beretwood.domain.Client;

public interface ClientDao {

	static ClientDao getInstance() {
		return new ClientDaoImpl();
	}

	Client save(Client client);
}
