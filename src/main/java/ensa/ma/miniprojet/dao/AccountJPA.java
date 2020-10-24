package ensa.ma.miniprojet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ensa.ma.miniprojet.entitie.Account;

public interface AccountJPA extends JpaRepository<Account, Integer>{
	Optional<Account> findByUsername(String username);

}
