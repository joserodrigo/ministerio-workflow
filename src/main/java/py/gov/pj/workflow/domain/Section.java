package py.gov.pj.workflow.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the section database table.
 * 
 */
@Entity
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTION_SECID_GENERATOR", sequenceName="SECTION_SEC_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTION_SECID_GENERATOR")
	@Column(name="sec_id")
	private Long secId;

	@Column(name="sec_del")
	private Integer secDel;

	@Column(name="sec_desc")
	private String secDesc;

	//bi-directional many-to-one association to Officer
	@OneToMany(mappedBy="section")
	private Set<Officer> officers;

    public Section() {
    }

	public Long getSecId() {
		return this.secId;
	}

	public void setSecId(Long secId) {
		this.secId = secId;
	}

	public Integer getSecDel() {
		return this.secDel;
	}

	public void setSecDel(Integer secDel) {
		this.secDel = secDel;
	}

	public String getSecDesc() {
		return this.secDesc;
	}

	public void setSecDesc(String secDesc) {
		this.secDesc = secDesc;
	}

	public Set<Officer> getOfficers() {
		return this.officers;
	}

	public void setOfficers(Set<Officer> officers) {
		this.officers = officers;
	}
	
}