package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the typeone database table.
 * 
 */
@Entity
public class Typeone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TYPEONE_TYPID_GENERATOR", sequenceName="TYPEONE_TYP_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPEONE_TYPID_GENERATOR")
	@Column(name="typ_id")
	private Long typId;

	@Column(name="travel_reason")
	private String travelReason;

    @Temporal( TemporalType.DATE)
	@Column(name="typ_dateoutput")
	private Date typDateoutput;

    @Temporal( TemporalType.DATE)
	@Column(name="typ_datereturn")
	private Date typDatereturn;

	@Column(name="typ_del")
	private Integer typDel;

	//bi-directional many-to-one association to Department
    @ManyToOne
	@JoinColumn(name="dep_id")
	private Department department;

	//bi-directional many-to-one association to Locality
    @ManyToOne
	@JoinColumn(name="loc_id")
	private Locality locality;

	//bi-directional many-to-one association to Officer
    @ManyToOne
	@JoinColumn(name="off_id")
	private Officer officer;

    public Typeone() {
    }

	public Long getTypId() {
		return this.typId;
	}

	public void setTypId(Long typId) {
		this.typId = typId;
	}

	public String getTravelReason() {
		return this.travelReason;
	}

	public void setTravelReason(String travelReason) {
		this.travelReason = travelReason;
	}

	public Date getTypDateoutput() {
		return this.typDateoutput;
	}

	public void setTypDateoutput(Date typDateoutput) {
		this.typDateoutput = typDateoutput;
	}

	public Date getTypDatereturn() {
		return this.typDatereturn;
	}

	public void setTypDatereturn(Date typDatereturn) {
		this.typDatereturn = typDatereturn;
	}

	public Integer getTypDel() {
		return this.typDel;
	}

	public void setTypDel(Integer typDel) {
		this.typDel = typDel;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Locality getLocality() {
		return this.locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	
	public Officer getOfficer() {
		return this.officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
	}
	
}