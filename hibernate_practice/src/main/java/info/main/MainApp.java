package info.main;

import java.util.Date;

import info.model.User;
import info.util.HibernateUtil;

import org.hibernate.Session;

public class MainApp {

	public static void main(String[] args) {
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = HibernateUtil.INSTANCE.getSession();
		User user = new User();
		user.setFirstName("user");
		user.setLastName("one");
		user.setDoj(new Date());
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
