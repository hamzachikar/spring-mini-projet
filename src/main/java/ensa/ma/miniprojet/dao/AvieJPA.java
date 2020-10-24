package ensa.ma.miniprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;

public interface AvieJPA extends JpaRepository<Avie, Integer>{
	public List<Avie> findByArticle(Article article);
	public List<Avie> findByRefere(User user);
}
