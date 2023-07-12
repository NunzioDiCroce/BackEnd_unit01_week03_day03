package gestioneEventi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locations")

public class Location {

	@Id
	// @GeneratedValue
	private long id;

	private String nome;
	private String citta;

	@OneToOne(mappedBy = "location")
	private Evento evento;

	// costruttori, getters e setters...
	public Location() {

	}

	public Location(long _id, String _nome, String _citta) {
		this.id = _id;
		this.nome = _nome;
		this.citta = _citta;
	}

	public Location(long _id, String _nome, String _citta, Evento _evento) {
		this.id = _id;
		this.nome = _nome;
		this.citta = _citta;
		this.evento = _evento;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento _evento) {
		this.evento = _evento;
	}

	@Override
	public String toString() {
		return "Location [ " + id + ", " + nome + ", " + citta + " ]";

	}
}
