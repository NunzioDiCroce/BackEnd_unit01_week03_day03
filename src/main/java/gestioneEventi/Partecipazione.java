package gestioneEventi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partecipazioni")

public class Partecipazione {

	@Id
	// @GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;

	private Stato stato;

	// costruttori, getters e setters...
	public Partecipazione() {

	}

	public Partecipazione(long _id, Stato _stato) {
		this.id = _id;
		this.stato = _stato;
	}

	public Partecipazione(long _id, Persona _persona, Evento _evento, Stato _stato) {
		this.id = _id;
		this.persona = _persona;
		this.evento = _evento;
		this.stato = _stato;
	}

	public long getId() {
		return id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona _persona) {
		this.persona = _persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento _evento) {
		this.evento = _evento;
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
