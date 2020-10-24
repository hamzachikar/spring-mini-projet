package ensa.ma.miniprojet.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="privilege")
public class Privilege {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String privName;
	public Privilege() {
	}
	public Privilege(int id, String privName) {
		this.id = id;
		this.privName = privName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrivName() {
		return privName;
	}
	public void setPrivName(String privName) {
		this.privName = privName;
	}
}
