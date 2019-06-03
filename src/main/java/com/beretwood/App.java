package com.beretwood;

import com.beretwood.command.ClientCreateCommand;
import com.beretwood.service.ClientService;
import com.beretwood.util.HibernateUtil;

public class App {
	static ClientService clientService = new ClientService();

	public static void main(String[] args) {
		ClientCreateCommand command1 = new ClientCreateCommand("test1", "W6");
		clientService.createClient(command1);

		ClientCreateCommand command2 = new ClientCreateCommand("test2", "W6");
		command2.setName("testa");
		command2.setSurname("testu");
		command2.setAddress1("aaa");
		clientService.createClient(command2);

		ClientCreateCommand command3 = new ClientCreateCommand("test1", "W6");
		clientService.createClient(command3);

		ClientCreateCommand command4 = new ClientCreateCommand("", "W6");
		clientService.createClient(command4);

		ClientCreateCommand command5 = new ClientCreateCommand("test5", "");
		clientService.createClient(command5);

		ClientCreateCommand command6 = new ClientCreateCommand("test3", "W6");
		clientService.createClient(command6);

		HibernateUtil.close();
	}
}
