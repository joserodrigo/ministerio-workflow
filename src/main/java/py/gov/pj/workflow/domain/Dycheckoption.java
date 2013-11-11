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
 * The persistent class for the dycheckoption database table.
 * 
 */
@Entity
public class Dycheckoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DYCHECKOPTION_DYCHECKID_GENERATOR", sequenceName="DYCHECKOPTION_DYCHECK_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DYCHECKOPTION_DYCHECKID_GENERATOR")
	@Column(name="dycheck_id")
	private Long dycheckId;

	@Column(name="dycheck_del")
	private Integer dycheckDel;

	@Column(name="dycheck_desc")
	private String dycheckDesc;

	//bi-directional many-to-one association to Checkruteo
	@OneToMany(mappedBy="dycheckoption")
	private Set<Checkruteo> checkruteos;

    public Dycheckoption() {
    }

	public Long getDycheckId() {
		return this.dycheckId;
	}

	public void setDycheckId(Long dycheckId) {
		this.dycheckId = dycheckId;
	}

	public Integer getDycheckDel() {
		return this.dycheckDel;
	}

	public void setDycheckDel(Integer dycheckDel) {
		this.dycheckDel = dycheckDel;
	}

	public String getDycheckDesc() {
		return this.dycheckDesc;
	}

	public void setDycheckDesc(String dycheckDesc) {
		this.dycheckDesc = dycheckDesc;
	}

	public Set<Checkruteo> getCheckruteos() {
		return this.checkruteos;
	}

	public void setCheckruteos(Set<Checkruteo> checkruteos) {
		this.checkruteos = checkruteos;
	}
	
}