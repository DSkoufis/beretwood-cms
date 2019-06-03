package com.beretwood.service;

import com.beretwood.command.ClientCreateCommand;
import com.beretwood.dao.ClientDao;
import com.beretwood.domain.Client;

public class ClientService {

	private ClientDao clientDao;

	public ClientService() {
		clientDao = ClientDao.getInstance();
	}

	public Client createClient(ClientCreateCommand command) {
		Client client = new Client(command.getEmail(), command.getPostCode());
		client.setName(command.getName());
		client.setSurname(command.getSurname());
		client.setAddress1(command.getAddress1());
		client.setAddress2(command.getAddress2());

		return clientDao.save(client);
	}
}
