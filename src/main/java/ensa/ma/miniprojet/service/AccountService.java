package ensa.ma.miniprojet.service;

import java.util.List;

import ensa.ma.miniprojet.entitie.Account;

public interface AccountService {
	public List<Account> findAll();
	public Account saveOrUpdate(Account account);
	public void delete(Account account);
}
