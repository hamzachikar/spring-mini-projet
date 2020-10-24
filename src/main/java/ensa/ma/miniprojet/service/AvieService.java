package ensa.ma.miniprojet.service;

import java.util.List;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.ArticleReferee;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;

public interface AvieService {
	public List<Avie>findAll();
	public Avie saveOrUpdate(Avie avie);
	public void delete(Avie avie);
	public List<Avie> getByArticle(Article article);
	public List<Avie> findByRefere(User user);
	public List<Avie> affectArticleToReferees(ArticleReferee articleReferee);
	public boolean updateContent(Avie avie);
}	
