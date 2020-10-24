package ensa.ma.miniprojet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.AvieService;

@RestController
@RequestMapping("/api/referee/avie")
public class RefereeRESTController {
	@Autowired
	private AvieService avieService;
	@GetMapping("")
	public boolean test() {
		return true;
	}
	@GetMapping("/all")
	public List<Avie>getAllAvieUser(@RequestBody User user){
		return this.avieService.findByRefere(user);
	}
	@PostMapping("")
	public boolean updateAvie(@RequestBody Avie avie) {
		return this.avieService.updateContent(avie);
	}
}
