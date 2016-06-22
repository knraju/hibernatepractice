package info.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="duser.findall1",query="from Stock")
})
public class NamedQueryHolder1 {
	
	@Id
	@GeneratedValue
	private Long id;

}
