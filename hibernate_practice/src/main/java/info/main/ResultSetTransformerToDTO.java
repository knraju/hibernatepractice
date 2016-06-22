package info.main;

import info.dto.StockDTO;
import info.util.HibernateUtil;

import java.util.List;

import onetomany.Stock;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

public class ResultSetTransformerToDTO {

	public static void main(String[] args) {
		
		/*hQLTransformersDemo();
		criteriaTransformersDemo();*/
		nativeSqlTransformersDemo();
	}

	private static void hQLTransformersDemo() {
		Session session = HibernateUtil.INSTANCE.getSession();
		Query query = session
				.createQuery("select s.stockName as stockName,sdr.priceOpen as openPrice,sdr.volume as volume from Stock as s join s.stockDailyRecords as sdr");
		query.setResultTransformer(Transformers.aliasToBean(StockDTO.class));
		List<StockDTO> stockDtoList = query.list();
		System.out.println(stockDtoList.size());
		System.out.println(stockDtoList);
		for (StockDTO stockDTO : stockDtoList) {
			System.out.println(stockDTO.getStockName() + " == "
					+ stockDTO.getOpenPrice() + " == " + stockDTO.getVolume());
		}
	}

	private static void criteriaTransformersDemo() {
		Session session = HibernateUtil.INSTANCE.getSession();
		Criteria criteria = session
				.createCriteria(Stock.class)
				.createAlias("stockDailyRecords", "sdr")
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("stockName").as("stockName"))
								//same as above // .add(Projections.property("stockName"),"stockName")
								.add(Projections.property("sdr.priceOpen").as(
										"openPrice"))
								.add(Projections.property("sdr.volume").as(
										"volume")))
				.setResultTransformer(Transformers.aliasToBean(StockDTO.class));

		List<StockDTO> stockDtoList = criteria.list();
		System.out.println(stockDtoList.size());
		System.out.println(stockDtoList);
	}

	private static void nativeSqlTransformersDemo() {

		String nativeQuery = "select s.stock_name as stockName,sdr.open_price as openPrice,sdr.volume as volume from test.stock_onetomany as s join test.stock_details_onetomany as sdr on s.stockId = sdr.stock_id";
		Session session = HibernateUtil.INSTANCE.getSession();
		List stockDtoList = session.createSQLQuery(nativeQuery)
				.addScalar("volume", StandardBasicTypes.LONG)
				.addScalar("stockName", StandardBasicTypes.STRING)
				.addScalar("openPrice", StandardBasicTypes.FLOAT)
				.setResultTransformer(Transformers.aliasToBean(StockDTO.class)).list();
		System.out.println(stockDtoList);
	}

}
