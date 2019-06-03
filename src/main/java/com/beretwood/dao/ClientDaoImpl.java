package com.beretwood.dao;

import com.beretwood.domain.Client;
import com.beretwood.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDaoImpl implements ClientDao {

	@Override
	public Client save(Client client) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.persist(client);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		}
		return client;
	}
}
