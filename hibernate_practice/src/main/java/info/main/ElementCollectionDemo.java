package info.main;

import java.util.Collection;

import org.hibernate.Session;

import info.model.Address;
import info.model.User;
import info.model.UserDetails;
import info.util.HibernateUtil;

public class ElementCollectionDemo {

	public static void main(String[] args) {
	
		/*UserDetails user = new UserDetails();
		user.setName("raju");
		Address add = new Address();
		add.setStreet("aranganal street");
		add.setCity("chennai");
		add.setState("Tamilanadu");
		
		Address add1 = new Address();
		add1.setStreet("apet");
		add1.setCity("hyd");
		add1.setState("Telangana");
		
		user.getAddresess().add(add1);
		user.getAddresess().add(add);*/
		
		
		Session session = HibernateUtil.INSTANCE.getSession();
		
//		session.save(user);
		UserDetails user = (UserDetails) session.load(UserDetails.class, 1l);
		System.out.println(user.getId());
//		Collection<Address> add = user.getAddresess();
		session.close();
	}

}
