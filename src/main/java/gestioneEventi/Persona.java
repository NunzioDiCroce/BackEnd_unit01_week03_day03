package gestioneEventi;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persone")

public class Persona {

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
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	private Sesso sesso;
	// *** TODO *** listaPartecipazioni ORDINATA PER dataEvento

	// costruttori, getters e setters...
	public Persona() {

	}

	public Persona(long _id, String _nome, String _cognome, String _email, LocalDate _dataNascita, Sesso _sesso) {
		this.id = _id;
		this.nome = _nome;
		this.cognome = _cognome;
		this.email = _email;
		this.dataNascita = _dataNascita;
		this.sesso = _sesso;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String _cognome) {
		this.cognome = _cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		this.email = _email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate _dataNascita) {
		this.dataNascita = _dataNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso _sesso) {
		this.sesso = _sesso;
	}

	@Override
	public String toString() {
		return "Persona [ " + id + ", " + nome + ", " + cognome + ", " + email + ", " + dataNascita + ", " + sesso
				+ " ]";

	}
}
