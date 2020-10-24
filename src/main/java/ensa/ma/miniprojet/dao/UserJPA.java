package ensa.ma.miniprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ensa.ma.miniprojet.entitie.User;

public interface UserJPA extends JpaRepository<User, Integer>{

}
