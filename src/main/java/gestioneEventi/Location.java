package gestioneEventi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")

public class Location {

	// id (chiave primaria)
	//
	//
	//
	//
	//

	@Id
	// @GeneratedValue
	private long id;

	private String nome;
	private String citta;

	// costruttori, getters e setters...
	public Location() {

	}

	public Location(long _id, String _nome, String _citta) {
		this.id = _id;
		this.nome = _nome;
		this.citta = _citta;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String _nome) {
		this.nome = _nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String _citta) {
		this.citta = _citta;
	}

	@Override
	public String toString() {
		return "Location [ " + id + ", " + nome + ", " + citta + " ]";

	}
}
