package py.gov.pj.workflow.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the checkruteo database table.
 * 
 */
@Entity
public class Checkruteo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CHECKRUTEO_CHECKRUTEOID_GENERATOR", sequenceName="CHECKRUTEO_CHECKRUTEO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CHECKRUTEO_CHECKRUTEOID_GENERATOR")
	@Column(name="checkruteo_id")
	private Long checkruteoId;

	@Column(name="checkruteo_del")
	private Integer checkruteoDel;

	private Boolean tildo;

	//bi-directional many-to-one association to Document
    @ManyToOne
	@JoinColumn(name="doc_id")
	private Document document;

	//bi-directional many-to-one association to Dycheckoption
    @ManyToOne
	@JoinColumn(name="dycheck_id")
	private Dycheckoption dycheckoption;

	//bi-directional many-to-one association to Routing
    @ManyToOne
	@JoinColumn(name="rou_id")
	private Routing routing;

    public Checkruteo() {
    }

	public Long getCheckruteoId() {
		return this.checkruteoId;
	}

	public void setCheckruteoId(Long checkruteoId) {
		this.checkruteoId = checkruteoId;
	}

	public Integer getCheckruteoDel() {
		return this.checkruteoDel;
	}

	public void setCheckruteoDel(Integer checkruteoDel) {
		this.checkruteoDel = checkruteoDel;
	}

	public Boolean getTildo() {
		return this.tildo;
	}

	public void setTildo(Boolean tildo) {
		this.tildo = tildo;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Dycheckoption getDycheckoption() {
		return this.dycheckoption;
	}

	public void setDycheckoption(Dycheckoption dycheckoption) {
		this.dycheckoption = dycheckoption;
	}
	
	public Routing getRouting() {
		return this.routing;
	}

	public void setRouting(Routing routing) {
		this.routing = routing;
	}
	
}