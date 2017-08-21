package com.hibernate.startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Employee empObj = new Employee();
		empObj.setName("John");

		Address addr1 = new Address();
		addr1.setCity("NewYork");
		addr1.setState("NY");
		addr1.setStreet("Lexington Ave");
		addr1.setZipCode("10023");

		Address addr2 = new Address();
		addr2.setCity("NewYork");
		addr2.setState("NY");
		addr2.setStreet("Madison Ave");
		addr2.setZipCode("91111");

		empObj.getAddress().add(addr1);
		empObj.getAddress().add(addr2);
		addr1.getEmployee().add(empObj);
		addr2.getEmployee().add(empObj);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(empObj);
		session.save(addr1);
		session.save(addr2);
		// session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
}
