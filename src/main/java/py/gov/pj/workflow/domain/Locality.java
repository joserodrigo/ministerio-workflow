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
 * The persistent class for the locality database table.
 * 
 */
@Entity
public class Locality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCALITY_LOCID_GENERATOR", sequenceName="LOCALITY_LOC_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALITY_LOCID_GENERATOR")
	@Column(name="loc_id")
	private Long locId;

	@Column(name="loc_del")
	private Integer locDel;

	@Column(name="loc_desc")
	private String locDesc;

	//bi-directional many-to-one association to Typeone
	@OneToMany(mappedBy="locality")
	private Set<Typeone> typeones;

    public Locality() {
    }

	public Long getLocId() {
		return this.locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	public Integer getLocDel() {
		return this.locDel;
	}

	public void setLocDel(Integer locDel) {
		this.locDel = locDel;
	}

	public String getLocDesc() {
		return this.locDesc;
	}

	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
	}

	public Set<Typeone> getTypeones() {
		return this.typeones;
	}

	public void setTypeones(Set<Typeone> typeones) {
		this.typeones = typeones;
	}
	
}