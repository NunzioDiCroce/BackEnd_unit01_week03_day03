package gestioneEventi;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
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

	@Override
	public String toString() {
		return "Evento [ " + id + ", " + titolo + ", " + dataEvento + ", " + descrizione + ", " + tipoEvento + ", "
				+ numeroMassimoPartecipanti + " ]";

	}
}
