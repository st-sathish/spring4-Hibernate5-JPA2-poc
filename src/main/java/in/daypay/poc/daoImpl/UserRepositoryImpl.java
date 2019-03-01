package in.daypay.poc.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import in.daypay.poc.beans.User;
import in.daypay.poc.dao.UserRepository;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("spring_poc");
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username, String password) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("User.findByUsername");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<User> users = query.getResultList();
			if(users.size() > 0) {
				return users.get(0);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void save(User user) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(User user) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User find(Integer userId) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("User.findById");
			query.setParameter("userId", userId);
			List<User> users = query.getResultList();
			if(users.size() > 0) {
				return users.get(0);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
}
