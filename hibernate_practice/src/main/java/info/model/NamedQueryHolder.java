package info.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="user.findall",query="from User"),
	@NamedQuery(name="duser.findall",query="from duser"),
})
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "findAllUsers",
			query = "CALL getAllUserDetails()",
			resultClass = UserDetails.class
			)
})
public class NamedQueryHolder {
	
	@Id
	@GeneratedValue
	private Long id;

}
