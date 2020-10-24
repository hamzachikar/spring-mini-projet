package ensa.ma.miniprojet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.ArticleService;

@RestController
@RequestMapping("/api/client/article")
public class NoAuthRESTController {
	@Autowired
	private ArticleService articleService;
	@GetMapping("")
	public List<Article> getVisitorArticle(){
		return this.articleService.getAllViewArticle();
	}
	@GetMapping("/auteur")
	public List<Article> getVisitorArticleByAuteur(@RequestBody User user){
		return this.articleService.findViewByAuteur(user);
	}
	@GetMapping("/{word}")
	public List<Article> getVisitorArticleByKeyWord(@PathVariable String word){
		return this.articleService.findViewByKeyWord(word);
	}
}
