package py.gov.pj.workflow.view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import py.gov.pj.workflow.business.OfficerBC;
import py.gov.pj.workflow.business.SectionBC;
import py.gov.pj.workflow.domain.Officer;
import py.gov.pj.workflow.domain.Section;

;

@ViewController
@PreviousView("/officer_list.xhtml")
public class OfficerEditMB extends AbstractEditPageBean<Officer, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OfficerBC officerBC;
	@Inject
	private SectionBC sectionBC;

	private List<SelectItem> selectOneItemSection;

	public List<SelectItem> getSelectOneItemSection() {

		this.selectOneItemSection = new ArrayList<SelectItem>();
		List<Section> secciones = sectionBC.listar();
		for (Section sec : secciones) {
			SelectItem selectItem = new SelectItem(sec.getSecId(),
					sec.getSecDesc());
			this.selectOneItemSection.add(selectItem);
		}
		return selectOneItemSection;
	}

	public List<Section> getSections() {

		return sectionBC.listar();
	}

	@Override
	@Transactional
	public String delete() {

		this.officerBC.eliminar(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {

		Officer func = getBean();
		func.setOffDel(0);
		func.setOffName(func.getOffName().toUpperCase());
		func.setOffLastname(func.getOffLastname().toUpperCase());
		func.setOffAddress(func.getOffAddress().toUpperCase());
		func.setOffPhone(func.getOffPhone().toUpperCase());
		func.setOffEmail(func.getOffPhone().toUpperCase());
		this.officerBC.insert(func);
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		Officer func = getBean();
		func.setOffName(func.getOffName().toUpperCase());
		func.setOffLastname(func.getOffLastname().toUpperCase());
		func.setOffAddress(func.getOffAddress().toUpperCase());
		func.setOffPhone(func.getOffPhone().toUpperCase());
		func.setOffEmail(func.getOffPhone().toUpperCase());
		this.officerBC.update(func);
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {

		setBean(this.officerBC.load(getId()));
	}

}
