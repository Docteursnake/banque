package org.gestion.bp.metier;

import java.util.Date;
import java.util.List;

import org.gestion.bp.dao.IBanqueDao;
import org.gestion.bp.entities.Client;
import org.gestion.bp.entities.Compte;
import org.gestion.bp.entities.Employe;
import org.gestion.bp.entities.Groupe;
import org.gestion.bp.entities.Operation;
import org.gestion.bp.entities.Retrait;
import org.gestion.bp.entities.Versement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
	
	private IBanqueDao dao;
		
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		// TODO Auto-generated method stub
		return dao.addEmploye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGR) {
		dao.addEmployeToGroupe(codeEmp, codeGR);
		
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
	
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	@Override
	public void Verser(double mt, String codeCpte, Long codeEmp) {
		
		dao.addOperation(new Versement(new Date(), mt ), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde() + mt);
		
	}

	@Override
	public void Retirer(double mt, String codeCpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(), mt ), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde() - mt);
		
	}

	@Override
	public void Virement(double mt, String codeCpte1, String codeCpte2,	Long codeEmp) {
		Retirer(mt, codeCpte1, codeEmp);
		Verser(mt, codeCpte2, codeEmp);
		
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(codeCpte);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClient(String mc) {
		// TODO Auto-generated method stub
		return dao.consulterClient(mc);
	}

	@Override
	public List<Compte> getComptesByClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.getComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		// TODO Auto-generated method stub
		return dao.getEmployesByGroupe(codeGr);
	}

}
