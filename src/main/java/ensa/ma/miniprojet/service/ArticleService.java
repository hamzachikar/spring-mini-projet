package ensa.ma.miniprojet.service;

import java.util.List;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;

public interface ArticleService {
	public List<Article> findAll();
	public List<Article> findByAuteur(User user);
	public List<Article> findByKeyWord(String word);
	public List<Article> getAllViewArticle();
	public List<Avie> getArticleAvie(Article article);
	public Article saveOrUpdate(Article article);
	public void delete(Article article);
	public void deleteById(int id);
	public void checkArticleState(Article article);
	public List<Article> findViewByAuteur(User user);
	public List<Article> findViewByKeyWord(String word);
	public List<Article> findAllArticleValid();
	public List<Article> findByAuteurValid(User user);
	public List<Article> findByKeyWordValid(String word);
	public Article validateAticle(Article article);
	public List<Article> getAttArticle();
	public List<Article> getArticleAuteur(User user);
	
}
