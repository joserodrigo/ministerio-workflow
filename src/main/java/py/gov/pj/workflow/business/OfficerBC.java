package py.gov.pj.workflow.business;

import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;
import py.gov.pj.workflow.domain.Officer;
import py.gov.pj.workflow.persistence.OfficerDAO;

@BusinessController
public class OfficerBC extends DelegateCrud<Officer, Long, OfficerDAO> {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private OfficerDAO funcDAO;
	public void eliminar(long Id){
		funcDAO.eliminar(Id);
	}
	
	public List<Officer> listar() {
		return funcDAO.listar();
	}
	
}
