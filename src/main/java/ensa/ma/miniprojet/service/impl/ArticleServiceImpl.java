package ensa.ma.miniprojet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.ArticleJPA;
import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.ArticleService;
import ensa.ma.miniprojet.service.AvieService;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleJPA repo;
	@Autowired 
	private AvieService avieService;
	@Override
	public Article saveOrUpdate(Article article) {
		return this.repo.save(article);
	}

	@Override
	public void delete(Article article) {
		this.repo.delete(article);
	}

	@Override
	public List<Article> findAll() {
		return this.repo.findAll();
	}

	@Override
	public void deleteById(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public List<Article> findByAuteur(User user) {
		return this.repo.findByAuteur(user);
	}

	@Override
	public List<Article> findByKeyWord(String word) {
		List<Article> articles=this.repo.findAll();
		List<Article>keyWordArticle=new ArrayList<Article>();
		if(!articles.isEmpty()) {
			for(Article article : articles) {
					for(String w:article.getKeyWord()) {
						if(w.equals(word)) {
							keyWordArticle.add(article);
							break;
						}
					}		
			}
		}
		return keyWordArticle;
	}

	@Override
	public List<Avie> getArticleAvie(Article article) {
		List<Avie> avies=this.avieService.getByArticle(article);
		List<Avie>vAvie=new ArrayList<Avie>();
		for(Avie avie:avies) {
			avie.setRefere(null);
			vAvie.add(avie);
		}
		return vAvie;
	}

	@Override
	public void checkArticleState(Article article) {
		if(article.getStatus().equals("en attente")) {
			article.setStatus("en cours");
			this.saveOrUpdate(article);
		}
		List<Avie>avies=this.getArticleAvie(article);
		boolean flag=true;
		for(Avie avie:avies){
			if(avie.getType()==null||avie.getType().equals("")) {
				System.out.println("waitin for other ref");
				flag=false;
				break;
			}
		}
		int point=0;
		if(flag) {
			for(Avie avie:avies){
				if(avie.getType().equals("accept")||avie.getType().equals("accept+")) {
					point=point+1;
				}
			}
			if(point>=2) {
				article.setValide(true);
				article.setStatus("accepted");
			}
			else {
				article.setValide(false);
				article.setStatus("rejected");
			}
			this.saveOrUpdate(article);
		}
	}

	@Override
	public List<Article> getAllViewArticle() {
		List<Article>articles=this.findAllArticleValid();
		List<Article>viewerA=new ArrayList<Article>();
		for(Article article:articles) {
				article.setContenu(null);
				viewerA.add(article);
		}
		return viewerA;
	}

	@Override
	public List<Article> findViewByAuteur(User user) {
		List<Article>articles=this.findByAuteurValid(user);
		List<Article>viewerA=new ArrayList<Article>();
		for(Article article:articles) {
			article.setContenu(null);
			viewerA.add(article);
		}
		return viewerA;
	}

	@Override
	public List<Article> findViewByKeyWord(String word) {
		List<Article>articles=this.findByKeyWordValid(word);
		List<Article>viewerA=new ArrayList<Article>();
		for(Article article:articles) {
			article.setContenu(null);
			viewerA.add(article);
		}
		return viewerA;
	}

	@Override
	public List<Article> findAllArticleValid() {
		List<Article>articles=this.findAll();
		List<Article>validArt=new ArrayList<Article>();
		for(Article article:articles) {
			if(article.getStatus().equals("valide")) {
				validArt.add(article);
			}
		}
		return validArt;
	}

	@Override
	public List<Article> findByAuteurValid(User user) {
		List<Article> articles=this.findByAuteur(user);
		List<Article>validArt=new ArrayList<Article>();
		for(Article article:articles) {
			if(article.getStatus().equals("valide")) {
				validArt.add(article);
			}
		}
		return validArt;
	}

	@Override
	public List<Article> findByKeyWordValid(String word) {
		List<Article> articles=this.findByKeyWord(word);
		List<Article>validArt=new ArrayList<Article>();
		for(Article article:articles) {
			if(article.getStatus().equals("valide")) {
				validArt.add(article);
			}
		}
		return validArt;
	}

	@Override
	public Article validateAticle(Article article) {
		return this.repo.save(article);
	}

	@Override
	public List<Article> getAttArticle() {
		return this.repo.findByStatus("en attente");
	}

	@Override
	public List<Article> getArticleAuteur(User user) {
		return this.repo.findByAuteur(user);
	}

	

}
