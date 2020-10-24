package ensa.ma.miniprojet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.ArticleService;
import ensa.ma.miniprojet.service.ReviewService;

@RestController
@RequestMapping("/api/user/article")
public class UserRESTController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ArticleService articleService;
	@PostMapping("")
	public boolean saveArticle(@RequestBody Article article) {
		return this.reviewService.validateArticle(article);
	}
	@GetMapping("/myArticle")
	public List<Article> findArticleAuteur(@RequestBody User user){
		return this.articleService.getArticleAuteur(user);
	}
	@PostMapping("/update")
	public boolean updateArticle(@RequestBody Article article) {
		return this.reviewService.updateArticle(article);
	}
	@GetMapping("")
	public List<Article> findAllArticles(){
		return this.articleService.findAllArticleValid();
	}
	@DeleteMapping("/{id}")
	public void deleteArticle(@PathVariable int id) {
		this.articleService.deleteById(id);
	}
	@GetMapping("/auteur")
	public List<Article> findArticleByAututeur(@RequestBody User user){
		return this.articleService.findByAuteurValid(user);
	}
	@GetMapping("/key/{word}")
	public List<Article> findArticleByKeyWord(@PathVariable String word){
		return this.articleService.findByKeyWordValid(word);
	}
	@GetMapping("/avie")
	public List<Avie> getArticleAvie(@RequestBody Article article){
		return this.articleService.getArticleAvie(article);
	}
	
}
