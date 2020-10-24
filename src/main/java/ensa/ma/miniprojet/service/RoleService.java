package ensa.ma.miniprojet.service;

import java.util.List;

import ensa.ma.miniprojet.entitie.Role;

public interface RoleService {
	public List<Role> findAll();
	public Role saveOrUpdate(Role role);
	public void delete(Role role);
}
