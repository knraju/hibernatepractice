package info.main;


import java.util.Date;

import info.model.User;
import info.util.HibernateUtil;

import org.hibernate.Session;

public class HibernateCurdMethods {

	public static void main(String[] args) {
		
//		saveOrUpdate();
		flushTest();
	}

	private static void flushTest() {
		Session session = HibernateUtil.INSTANCE.getSession();
		User user = new User();
		user.setFirstName("flushfn");
		user.setLastName("flushln");
		user.setDoj(new Date());
//		user.setUserId(7l);
		session.beginTransaction();
		session.save(user);
		
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	private static void saveOrUpdate() {
		
		Session session = HibernateUtil.INSTANCE.getSession();
		User user = new User();
		user.setFirstName("fnameaaa");
		user.setLastName("lnameaaaa");
		user.setDoj(new Date());
//		user.setUserId(7l);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		Session s = HibernateUtil.INSTANCE.getSession();
		s.beginTransaction();
		user.setLastName("updatedlastname");
		s.save(user);
		s.getTransaction().commit();
		System.out.println(user.getLastName());
		System.out.println(user.getUserId());
	}

}
