package ensa.ma.miniprojet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.AvieJPA;
import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.ArticleReferee;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.ArticleService;
import ensa.ma.miniprojet.service.AvieService;

@Service
public class AvieServiceImpl implements AvieService{
	@Autowired
	private AvieJPA repo;
	@Autowired
	private ArticleService articleService;
	@Override
	public Avie saveOrUpdate(Avie avie) {
		avie=this.repo.save(avie);
		articleService.checkArticleState(avie.getArticle());
		return avie;
	}

	@Override
	public void delete(Avie avie) {
		this.repo.delete(avie);
	}

	@Override
	public List<Avie> getByArticle(Article article) {
		return this.repo.findByArticle(article);
	}

	@Override
	public List<Avie> findAll() {
		return this.repo.findAll();
	}

	@Override
	public List<Avie> findByRefere(User user) {
		List<Avie> aviesRef=this.repo.findByRefere(user);
		List<Avie> avies=new ArrayList<Avie>();
		for(Avie avie:aviesRef) {
			if(avie.getArticle().getStatus().equals("en cours")) {
				Article article=avie.getArticle();
				article.setAuteur(null);
				article.setCoAuteur(null);
				avie.setArticle(article);
			}
			avies.add(avie);
		}
		return avies;
	}

	@Override
	public List<Avie> affectArticleToReferees(ArticleReferee articleReferee) {
		List<Avie> avies =new ArrayList<Avie>();
		for(User user:articleReferee.getReferee()){
			Avie avie=new Avie();
			avie.setArticle(articleReferee.getArticle());
			avie.setRefere(user);
			avie=this.repo.save(avie);
			avies.add(avie);
		}
		return avies;
	}

	@Override
	public boolean updateContent(Avie avie) {
		Avie a=this.repo.findById(avie.getId()).get();
		a.setContenu(avie.getContenu());
		a.setType(avie.getType());
		this.repo.save(a);
		return true;
	}

}
