package ensa.ma.miniprojet.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ensa.ma.miniprojet.entitie.Account;
import ensa.ma.miniprojet.entitie.Privilege;
import ensa.ma.miniprojet.entitie.Role;


public class MyUserDetails implements UserDetails{
	private Account compte;
	public MyUserDetails(Account compte) {
		this.compte=compte;
	}
	public MyUserDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getGrantedAuthorities(this.compte.getRoles());
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.compte.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.compte.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.compte.isActive();
	}
	 private List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
	        }
	        return authorities;
	    }
	 
	 
}
