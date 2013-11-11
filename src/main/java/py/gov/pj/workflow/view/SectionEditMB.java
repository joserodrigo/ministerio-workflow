package py.gov.pj.workflow.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.SectionBC;
import py.gov.pj.workflow.domain.Section;

@ViewController
@PreviousView("/section_list.xhtml")
public class SectionEditMB extends AbstractEditPageBean<Section, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SectionBC sectionBC;
	
	
	@Override
	@Transactional
	public String delete() {
		this.sectionBC.eliminar(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		Section obj = getBean();
		obj.setSecDel(0);
		obj.setSecDesc(obj.getSecDesc().toUpperCase());
		this.sectionBC.insert(obj);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		Section obj = getBean();
		obj.setSecDesc(obj.getSecDesc().toUpperCase());
		this.sectionBC.update(obj);
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.sectionBC.load(getId()));
	}

}