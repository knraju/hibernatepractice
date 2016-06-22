package info.util;

import java.io.Serializable;
import java.util.Date;





import org.hibernate.event.internal.DefaultSaveEventListener;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.persister.entity.EntityPersister;

public class SaveOrUpdateDateListner extends DefaultSaveEventListener {
	
	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent model) {
		if (model.getObject() instanceof DateListner) {
			DateListner dl = (DateListner) model;
			dl.setLastUpdatedDate(new Date());
			
		}
		super.onSaveOrUpdate(model);
	}
	
	@Override
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event) {
		// TODO Auto-generated method stub
		return super.performSaveOrUpdate(event);
	}
	
	@Override
	protected Serializable performSave(Object arg0, Serializable arg1,
			EntityPersister arg2, boolean arg3, Object arg4, EventSource arg5,
			boolean arg6) {
		// TODO Auto-generated method stub
		return super.performSave(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
	
	public SaveOrUpdateDateListner() {
		System.out.println("saveorupdatedatelistner=========");
	}

}
