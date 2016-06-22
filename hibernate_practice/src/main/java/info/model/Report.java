package info.model;

import info.util.DateListner;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="report")
public class Report implements DateListner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long reportId;
	
	@Temporal(TemporalType.DATE)
	private Date generatedDate;
	
	@Column(scale=2)
	private BigDecimal amout;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Patient patient;

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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public Date getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Date generatedDate) {
		this.generatedDate = generatedDate;
	}

	public BigDecimal getAmout() {
		return amout;
	}

	public void setAmout(BigDecimal amout) {
		this.amout = amout;
	}
	
	
}
