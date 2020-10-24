package ensa.ma.miniprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.User;

public interface ArticleJPA extends JpaRepository<Article, Integer>{
	public List<Article> findByAuteur(User user);
	public List<Article> findByStatus(String status);
}	
