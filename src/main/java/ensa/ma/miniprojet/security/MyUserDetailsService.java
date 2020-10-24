package ensa.ma.miniprojet.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.AccountJPA;
import ensa.ma.miniprojet.entitie.Account;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	AccountJPA repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> compte=repo.findByUsername(username);
		compte.orElseThrow(()->new UsernameNotFoundException("not found"));
		return compte.map(MyUserDetails::new).get();
	}
	
}
