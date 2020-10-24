package ensa.ma.miniprojet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.AccountJPA;
import ensa.ma.miniprojet.entitie.Account;
import ensa.ma.miniprojet.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountJPA repo;

	@Override
	public Account saveOrUpdate(Account account) {
		return this.repo.save(account);
	}

	@Override
	public void delete(Account account) {
		this.repo.delete(account);
	}

	@Override
	public List<Account> findAll() {
		return this.repo.findAll();
	}
	
}
