package com.beretwood.util;

import com.mysql.cj.jdbc.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL55Dialect;
import org.hibernate.service.ServiceRegistry;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.util.Properties;
import java.util.Set;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		sessionFactory = loadSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void close() {
		if (!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}

	private static SessionFactory loadSessionFactory() {
		try {
			Configuration configuration = new Configuration();

			configuration.setProperties(getProperties());
			addClasses(configuration);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Properties getProperties() {
		Properties settings = new Properties();
		settings.put(Environment.DRIVER, Driver.class.getName());
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/beretwood?useSSL=false");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "");
		settings.put(Environment.DIALECT, MySQL55Dialect.class.getName());
		settings.put(Environment.SHOW_SQL, "false");
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		settings.put(Environment.HBM2DDL_AUTO, "create");
		return settings;
	}

	private static void addClasses(Configuration config) {
		for (Class clazz : getAnnotatedClasses()) {
			config.addAnnotatedClass(clazz);
		}
	}

	private static Set<Class<?>> getAnnotatedClasses() {
		Reflections reflections = new Reflections("com.beretwood.domain");
		return reflections.getTypesAnnotatedWith(Entity.class);
	}
}
