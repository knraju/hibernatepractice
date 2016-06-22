package onetomany;

import java.util.Date;

import info.util.HibernateUtil;

import org.hibernate.Session;

public class OneToManyDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.INSTANCE.getSession();
		
		Stock stock = new Stock();
		stock.setStockCode("s_123");
		stock.setStockName("stockone");
		
		StockDailyRecord sdr = new StockDailyRecord();
		sdr.setDate(new Date());
		sdr.setPriceOpen(25.5f);
		sdr.setVolume(10l);
		sdr.setStock(stock);
		
		StockDailyRecord sdr1 = new StockDailyRecord();
		sdr1.setDate(new Date());
		sdr1.setPriceOpen(35.5f);
		sdr1.setVolume(20l);
		sdr1.setStock(stock);
		
		stock.getStockDailyRecords().add(sdr);
		stock.getStockDailyRecords().add(sdr1);
		
		
		
		session.beginTransaction();
		session.saveOrUpdate(stock);
		session.getTransaction().commit();
		session.close();

	}

}
