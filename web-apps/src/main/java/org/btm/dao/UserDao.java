package org.btm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.btm.dto.User;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(user);

		transaction.begin();
		transaction.commit();

		return user;
	}

	public User updateUser(User user) {
		EntityTransaction transaction = manager.getTransaction();

		manager.merge(user);

		transaction.begin();
		transaction.commit();

		return user;
	}

	public void deleteUser(int id) {
		User user = manager.find(User.class, id);
		if (user != null) {
			EntityTransaction transaction = manager.getTransaction();

			manager.remove(user);
			System.out.println("Deleted Succesfull");
			transaction.begin();
			transaction.commit();
		} else {
			System.out.println("Data not found");
		}
	}

	public User getUser(int id) {
		return manager.find(User.class, id);
	}

	public List<User> getAllUsers() {
		Query query = manager.createQuery("select user from User user");
		List<User> users = query.getResultList();
		return users;

	}

	public User verifyUser(long phone, String pass) {
		String qry = "select user from User user where user.phone=?1 and user.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, pass);
		List<User> users = q.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;

	}

}
