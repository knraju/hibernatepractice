package info.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table
public class UserDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@ElementCollection
	@JoinTable(name="user_address",joinColumns=@JoinColumn(name="user_id"))
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns = { @Column(name="add_id") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> addresess = new ArrayList();
	

	public Collection<Address> getAddresess() {
		return addresess;
	}

	public void setAddresess(Collection<Address> addresess) {
		this.addresess = addresess;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
