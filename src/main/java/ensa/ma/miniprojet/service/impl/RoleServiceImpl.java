package ensa.ma.miniprojet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.RoleJPA;
import ensa.ma.miniprojet.entitie.Role;
import ensa.ma.miniprojet.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleJPA repo;
	@Override
	public Role saveOrUpdate(Role role) {
		return this.repo.save(role);
	}

	@Override
	public void delete(Role role) {
		this.repo.delete(role);
	}

	@Override
	public List<Role> findAll() {
		return this.repo.findAll();
	}
	

}
