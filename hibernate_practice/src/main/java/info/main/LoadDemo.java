package info.main;

import info.model.Patient;
import info.model.Report;
import info.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class LoadDemo {

	public static void main(String[] args) {
Session session = HibernateUtil.INSTANCE.getSession();
		
	
		/*Patient p = (Patient) session.load(Patient.class, 2l);
		Report r = new Report();
		r.setAmout(new BigDecimal(350));
		r.setGeneratedDate(new Date());
		r.setPatient(p);
		
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();*/
		List<Patient> plist = session.createQuery("from Patient").list();
		for (Patient patient : plist) {
			System.out.println(patient.getReports().size());
		}
		session.close();

	}

}
