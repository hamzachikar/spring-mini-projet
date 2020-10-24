package ensa.ma.miniprojet.entitie;

import java.util.List;

public class ArticleReferee {
	private Article article;
	private List<User> referee;
	public ArticleReferee() {
	}
	
	public ArticleReferee(Article article, List<User> referee) {
		this.article = article;
		this.referee = referee;
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public List<User> getReferee() {
		return referee;
	}
	public void setReferee(List<User> referee) {
		this.referee = referee;
	}
	
}
