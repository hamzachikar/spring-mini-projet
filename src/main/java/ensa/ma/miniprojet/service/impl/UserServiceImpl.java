package ensa.ma.miniprojet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.UserJPA;
import ensa.ma.miniprojet.entitie.Role;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserJPA repo;

	@Override
	public List<User> findAll() {
		return this.repo.findAll();
	}

	@Override
	public User saveOrUpdate(User user) {
		return this.repo.save(user);
	}

	@Override
	public void delete(User user) {
		this.repo.delete(user);
		
	}

	@Override
	public User findById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public List<User> findAllReferee() {
		List<User>users=this.repo.findAll();
		List<User>referee=new ArrayList<User>();
		for(User user:users) {
			for(Role role:user.getAccount().getRoles()) {
				if(role.getRoleName().equals("ROLE_REFEREE")) {
					referee.add(user);
					break;
				}
			}
		}
		return referee;
	}
}
