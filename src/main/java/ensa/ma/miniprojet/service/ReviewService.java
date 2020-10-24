package ensa.ma.miniprojet.service;

import ensa.ma.miniprojet.entitie.Article;

public interface ReviewService {
	public boolean validateArticle(Article article);
	public boolean updateArticle(Article article);
}
