package ensa.ma.miniprojet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ensa.ma.miniprojet.entitie.Account;
import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.ArticleReferee;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.Privilege;
import ensa.ma.miniprojet.entitie.Role;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.AccountService;
import ensa.ma.miniprojet.service.ArticleService;
import ensa.ma.miniprojet.service.AvieService;
import ensa.ma.miniprojet.service.PrivilegeService;
import ensa.ma.miniprojet.service.RoleService;
import ensa.ma.miniprojet.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminRESTController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private AvieService avieService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private PrivilegeService privService;
	@Autowired
	private RoleService roleService;
	@GetMapping("/article")
	public List<Article> getAllArticle(){
		return this.articleService.findAll();
	}
	@GetMapping("/article/att")
	public List<Article> getAttArticle(){
		return this.articleService.getAttArticle();
	}
	@PostMapping("/article")
	public Article validateArticle(@RequestBody Article article) {
		return this.articleService.validateAticle(article);
	}
	@GetMapping("/article/avie")
	public List<Avie> getArticleAvie(@RequestBody Article article){
		return this.avieService.getByArticle(article);
	}
	@GetMapping("/referee")
	public List<User> getAllReferee(){
		return this.userService.findAllReferee();
	}
	@PostMapping("/affect")
	public List<Avie> affectArticleReferees(@RequestBody ArticleReferee articleReferee){
		return this.avieService.affectArticleToReferees(articleReferee);
	}
	@PostMapping("/user")
	public User saveOrUpdateUser(@RequestBody User user) {
		return this.userService.saveOrUpdate(user);
	}
	@GetMapping("/account")
	public List<Account> getAllAccount(){
		return this.accountService.findAll();
	}
	@PostMapping("/account")
	public Account saveOrUpdateAccount(@RequestBody Account account) {
		return this.accountService.saveOrUpdate(account);
	}
	@GetMapping("/user")
	public List<User> getUsers(){
		return this.userService.findAll();
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return this.userService.findById(id);
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		this.userService.deleteById(id);
	}
	@GetMapping("/privilege")
	public List<Privilege> getAllPriv(){
		return this.privService.findAll();
	}
	@PostMapping("/privilege")
	public Privilege saveOrUpdatePriv(@RequestBody Privilege privilege) {
		return this.privService.saveOrUpdate(privilege);
	}
	@GetMapping("/role")
	public List<Role> getAllRole(){
		return this.roleService.findAll();
	}
	@PostMapping("/role")
	public Role saveOrUpdateRole(@RequestBody Role role) {
		return this.roleService.saveOrUpdate(role);
	}
}
