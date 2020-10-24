package ensa.ma.miniprojet.entitie;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="titre")
	private String titre;
	@Column(name="resume")
	private String resume;
	@Column(name="affiliation")
	private String affiliation;
	@ElementCollection
	private List<String> keyWord;
	@Column(name="contenu")
	private String contenu;
	@Column(name="valide")
	private boolean valide;
	@Column(name="status")
	private String status;
	@ManyToOne
	private User auteur;
	@ManyToMany
	private List<User> coAuteur;
	public Article() {
	}
	
	public Article(int id, String titre, String resume, String affiliation, List<String> keyWord, String contenu,
			boolean valide, String status, User auteur, List<User> coAuteur) {
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.affiliation = affiliation;
		this.keyWord = keyWord;
		this.contenu = contenu;
		this.valide = valide;
		this.status = status;
		this.auteur = auteur;
		this.coAuteur = coAuteur;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public List<String> getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(List<String> keyWord) {
		this.keyWord = keyWord;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public User getAuteur() {
		return auteur;
	}
	public void setAuteur(User auteur) {
		this.auteur = auteur;
	}
	public List<User> getCoAuteur() {
		return coAuteur;
	}
	public void setCoAuteur(List<User> coAuteur) {
		this.coAuteur = coAuteur;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
