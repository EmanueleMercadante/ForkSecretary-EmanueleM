package it.dedagroup.project_cea.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import it.dedagroup.project_cea.dto.request.TechnicianRequest;
import it.dedagroup.project_cea.model.Intervention;
import it.dedagroup.project_cea.model.Secretary;
import it.dedagroup.project_cea.model.Technician;
import it.dedagroup.project_cea.model.User;
import it.dedagroup.project_cea.service.def.TechnicianServiceDef;

@Service
public class TechnicianServiceImpl implements TechnicianServiceDef{

	@Override
	public Technician addTechnician(User user, List<Intervention> interventions, Secretary secretary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeTechnician(TechnicianRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Technician t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Technician> findBySecretary(long idSecretary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Technician> findByIntervention(long idIntervention) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Technician> findById(long idTechnician) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Technician> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
