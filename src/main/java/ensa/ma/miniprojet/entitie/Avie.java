package ensa.ma.miniprojet.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="avie")
public class Avie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="type")
	private String type;
	@Column(name="contenu")
	private String contenu;
	@OneToOne
	private User refere;
	@OneToOne
	private Article article;
	public Avie() {
	}
	public Avie(int id, String type, String contenu, User refere, Article article) {
		this.id = id;
		this.type = type;
		this.contenu = contenu;
		this.refere = refere;
		this.article = article;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public User getRefere() {
		return refere;
	}
	public void setRefere(User refere) {
		this.refere = refere;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
}
