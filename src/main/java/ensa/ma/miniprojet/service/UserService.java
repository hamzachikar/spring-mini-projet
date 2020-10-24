package ensa.ma.miniprojet.service;

import java.util.List;

import ensa.ma.miniprojet.entitie.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int id);
	public User saveOrUpdate(User user);
	public void delete(User user);
	public void deleteById(int id);
	public List<User> findAllReferee();
}
