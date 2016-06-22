package info.main;

import info.model.StockNameAndCode;
import info.model.UserDetails;
import info.util.HibernateUtil;

import java.util.List;

import onetomany.Stock;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;

public class HibernateDemo {

	public static void main(String[] args) {
		
		/*Session session = HibernateUtil.INSTANCE.getSession();
		List list = session.createQuery("from info.dummy.model.User").list();
		System.out.println(list);*/
		projectionWithOjectArry();

	}
	
	private static void namedQueryDemo() {
	
		Session session = HibernateUtil.INSTANCE.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List list = session.getNamedQuery("duser.findall").list();
		System.out.println(list);
		session.getTransaction().commit();
		
	}
	
	private static void storedProcedureDemo() {
		Session session = HibernateUtil.INSTANCE.getSession();
		List<UserDetails> userList = session.getNamedQuery("findAllUsers").list();
		System.out.println(userList);
	}
	
	private static void loadDemo() {
		Session session = HibernateUtil.INSTANCE.getSession();
		UserDetails user = (UserDetails) session.load(UserDetails.class, 1l);
		System.out.println(user.getId());
//		Collection<Address> add = user.getAddresess();
		session.close();
	}
	
	private static void getDemo() {
		Session session = HibernateUtil.INSTANCE.getSession();
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1l);
		System.out.println(user.getId());
		session.close();
		
	}
	
	private static void projectionWithAlias() {
		Session session = HibernateUtil.INSTANCE.getSession();
		Criteria criteria = session.createCriteria(Stock.class);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.alias(Projections.property("stockCode"), "code"))
				.add(Projections.alias(Projections.property("stockName"), "name"))
				).setResultTransformer(new AliasToBeanResultTransformer(StockNameAndCode.class));
		List list = criteria.list();
		System.out.println(list);
		session.close();
		
	}
	
	private static void projectionWithOjectArry() {
		Session session = HibernateUtil.INSTANCE.getSession();
		Criteria criteria = session.createCriteria(Stock.class);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("stockCode"))
				.add(Projections.property("stockName"))
				);
		List list = criteria.list();
		System.out.println(list);
		session.close();
		
	}

}


