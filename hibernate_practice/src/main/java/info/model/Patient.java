package info.model;

import info.util.DateListner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.metamodel.source.annotations.attribute.type.LobTypeResolver;

@Entity
@Table(name="patient")
public class Patient implements DateListner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long patientId;
	
	@Column(name="patient_name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Lob
	private String address;
	
	@Temporal(TemporalType.DATE)
	private Date insertionDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastUpdatedDate;
	
	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="patient")
	private Set<Report> reports = new HashSet<>();
	
	
	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	

}
