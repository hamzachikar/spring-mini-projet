package ensa.ma.miniprojet.service;

import java.util.List;

import ensa.ma.miniprojet.entitie.Privilege;

public interface PrivilegeService {
	public List<Privilege> findAll();
	public Privilege saveOrUpdate(Privilege privilege);
	public void delete(Privilege privilege);
}
