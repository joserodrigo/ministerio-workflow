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
 * The persistent class for the department database table.
 * 
 */
@Entity
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTMENT_DEPID_GENERATOR", sequenceName="DEPARTMENT_DEP_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENT_DEPID_GENERATOR")
	@Column(name="dep_id")
	private Long depId;

	@Column(name="dep_del")
	private Integer depDel;

	@Column(name="dep_desc")
	private String depDesc;

	//bi-directional many-to-one association to Typeone
	@OneToMany(mappedBy="department")
	private Set<Typeone> typeones;

    public Department() {
    }

	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public Integer getDepDel() {
		return this.depDel;
	}

	public void setDepDel(Integer depDel) {
		this.depDel = depDel;
	}

	public String getDepDesc() {
		return this.depDesc;
	}

	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}

	public Set<Typeone> getTypeones() {
		return this.typeones;
	}

	public void setTypeones(Set<Typeone> typeones) {
		this.typeones = typeones;
	}
	
}