package info.main;

import java.math.BigDecimal;
import java.util.Date;

import info.model.Patient;
import info.model.Report;
import info.util.HibernateUtil;

import org.hibernate.Session;

public class OneToManyDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.INSTANCE.getSession();
		
		Patient p = new Patient();
		
		p.setAge(30);
		p.setDob(new Date(1990, 10, 15));
		p.setName("ramu");
		p.setAddress("srnagar,hyd,telangana");
		
		Report r = new Report();
		r.setAmout(new BigDecimal(250));
		r.setGeneratedDate(new Date());
		
		p.getReports().add(r);
		r.setPatient(p);
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		session.close();
	}

}
