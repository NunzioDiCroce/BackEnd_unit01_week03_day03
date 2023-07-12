package gestioneEventi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partecipazioni")

public class Partecipazione {

	// id (chiave primaria)
	//
	//
	//
	//
	//

	@Id
	// @GeneratedValue
	private long id;

	// *** TODO *** persona;
	// *** TODO *** evento;
	private Stato stato;

	// costruttori, getters e setters...
	public Partecipazione() {

	}

	public Partecipazione(long _id, Stato _stato) {
		this.id = _id;
		this.stato = _stato;
	}

	public long getId() {
		return id;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato _stato) {
		this.stato = _stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [ " + id + ", " + stato + " ]";

	}
}
