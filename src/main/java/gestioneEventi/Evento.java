package gestioneEventi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventi")

public class Evento {

	// id (chiave primaria)
	// titolo
	// dataEvento
	// descrizione
	// tipoEvento [PUBBLICO, PRIVATO]
	// numeroMassimoPartecipanti

	@Id
	// @GeneratedValue
	private long id;

	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	private TipoEvento tipoEvento;
	private int numeroMassimoPartecipanti;

	@OneToMany(mappedBy = "evento")
	private Set<Partecipazione> partecipazioni;

	@OneToOne
	private Location location;

	// costruttori, getters e setters...
	public Evento() {

	}

	public Evento(long _id, String _titolo, LocalDate _dataEvento, String _descrizione, TipoEvento _tipoEvento,
			int _numeroMassimoPartecipanti) {
		this.id = _id;
		this.titolo = _titolo;
		this.dataEvento = _dataEvento;
		this.descrizione = _descrizione;
		this.tipoEvento = _tipoEvento;
		this.numeroMassimoPartecipanti = _numeroMassimoPartecipanti;
	}

	public Evento(long _id, String _titolo, LocalDate _dataEvento, String _descrizione, TipoEvento _tipoEvento,
			int _numeroMassimoPartecipanti, Set<Partecipazione> _partecipazioni, Location _location) {
		this.id = _id;
		this.titolo = _titolo;
		this.dataEvento = _dataEvento;
		this.descrizione = _descrizione;
		this.tipoEvento = _tipoEvento;
		this.numeroMassimoPartecipanti = _numeroMassimoPartecipanti;
		this.partecipazioni = _partecipazioni;
		this.location = _location;
	}

	public long getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String _titolo) {
		this.titolo = _titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate _dataEvento) {
		this.dataEvento = _dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String _descrizione) {
		this.descrizione = _descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento _tipoEvento) {
		this.tipoEvento = _tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int _numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = _numeroMassimoPartecipanti;
	}

	public Set<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(Set<Partecipazione> _partecipazioni) {
		this.partecipazioni = _partecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location _location) {
		this.location = _location;
	}

	@Override
	public String toString() {
		return "Evento [ " + id + ", " + titolo + ", " + dataEvento + ", " + descrizione + ", " + tipoEvento + ", "
				+ numeroMassimoPartecipanti + " ]";

	}
}
