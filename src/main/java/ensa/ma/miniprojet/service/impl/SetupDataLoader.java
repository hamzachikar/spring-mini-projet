package ensa.ma.miniprojet.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.zip.Deflater;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ensa.ma.miniprojet.dao.AccountJPA;
import ensa.ma.miniprojet.dao.PrivilegeJPA;
import ensa.ma.miniprojet.dao.RoleJPA;
import ensa.ma.miniprojet.dao.UserJPA;
import ensa.ma.miniprojet.entitie.Account;
import ensa.ma.miniprojet.entitie.Privilege;
import ensa.ma.miniprojet.entitie.Role;
import ensa.ma.miniprojet.entitie.User;


//@Component
public class SetupDataLoader implements
  ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private AccountJPA accountRepo;
	@Autowired
	private UserJPA userRepo;
	@Autowired
	private RoleJPA roleRepo;
	@Autowired
	private PrivilegeJPA privRepo;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Privilege p1=new Privilege();
		p1.setPrivName("READ");
		Privilege p2=new Privilege();
		p2.setPrivName("WRITE");
		p1=this.privRepo.save(p1);
		p2=this.privRepo.save(p2);
		List<Privilege>priv=new ArrayList<Privilege>();
		Role role=new Role();
		priv.add(p1);
		priv.add(p2);
		role.setRoleName("ROLE_USER");
		role.setPrivilege(priv);
		role=this.roleRepo.save(role);
		List<Role>roles=new ArrayList<Role>();
		roles.add(role);
		Account account=new Account();
		account.setActive(true);
		account.setUsername("hamzachikar");
		account.setPassword("complexe");
		account.setRoles(roles);
		account=this.accountRepo.save(account);
		User user=new User();
		user.setAccount(account);
		user.setNom("chikar");
		user.setPrenom("hamza");
		user.setRate(6);
		this.userRepo.save(user);
	}
}
