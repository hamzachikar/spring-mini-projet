package ensa.ma.miniprojet.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ensa.ma.miniprojet.dao.AccountJPA;
import ensa.ma.miniprojet.entitie.Account;
import ensa.ma.miniprojet.entitie.AuthenticationRequest;
import ensa.ma.miniprojet.entitie.AuthenticationResponse;
import ensa.ma.miniprojet.security.JwtUtil;
import ensa.ma.miniprojet.security.MyUserDetailsService;


@RestController
@RequestMapping("/api")
public class AuthenticationApi {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private AccountJPA accountRepo;
	@PostMapping("/authenticate")
	public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest )throws Exception{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final Account account=accountRepo.findByUsername(authenticationRequest.getUsername()).get();
		final String jwt=jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(account,jwt));
	}
}
