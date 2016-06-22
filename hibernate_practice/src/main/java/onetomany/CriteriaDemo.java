package onetomany;

import info.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class CriteriaDemo {

	public static void main(String[] args) {

		Session session = HibernateUtil.INSTANCE.getSession();
		Criteria criteria = session.createCriteria(Stock.class);
		
		Criterion volume = Restrictions.eq("volume", 10l);
		Criterion price =  Restrictions.ge("priceOpen", 25f);
		
		LogicalExpression orexp = Restrictions.or(volume, price);
		criteria.add(orexp);
		
		
		System.out.println(criteria.list().size());
		session.close();
	}

}
