package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.LocalityBC;
import py.gov.pj.workflow.domain.Locality;

@ViewController
@PreviousView("/locality_list.xhtml")
public class LocalityEditMB extends AbstractEditPageBean<Locality, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LocalityBC localityBC;
	
	@Override
	@Transactional
	public String delete() {
		this.localityBC.eliminar(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		Locality locality = getBean();
		locality.setLocDel(0);
		locality.setLocDesc(locality.getLocDesc().toUpperCase());
		this.localityBC.insert(locality);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		Locality locality = getBean();
		locality.setLocDesc(locality.getLocDesc().toUpperCase());
		this.localityBC.update(locality);
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.localityBC.load(getId()));
	}

}