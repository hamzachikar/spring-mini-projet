package ensa.ma.miniprojet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.PrivilegeJPA;
import ensa.ma.miniprojet.entitie.Privilege;
import ensa.ma.miniprojet.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{
	@Autowired
	private PrivilegeJPA repo;

	@Override
	public Privilege saveOrUpdate(Privilege privilege) {
		return this.repo.save(privilege);
	}

	@Override
	public void delete(Privilege privilege) {
		this.repo.delete(privilege);
	}

	@Override
	public List<Privilege> findAll() {
		return this.repo.findAll();
	}
}
