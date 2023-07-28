package SI_Secure.dao.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Si_Version implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4404952185789269950L;
	@Id
	private int id;
	private String equipement;
	private String model;
	public int getId() {
		return id;
	}
	
	
	
	@Override
	public String toString() {
		return "Si_Version [id=" + id + ", equipement=" + equipement + ", model=" + model + ", os=" + os + ", eol="
				+ eol + "]";
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getEquipement() {
		return equipement;
	}
	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getEol() {
		return eol;
	}
	public void setEol(String eol) {
		this.eol = eol;
	}
	private String os;
	private String eol;


}
