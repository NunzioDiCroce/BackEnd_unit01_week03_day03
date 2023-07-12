package gestioneEventi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import utils.JpaUtil;

public class App {

	private static EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("");
		System.out
				.println("- - - - - - - - - - - - - - - App Gestione Eventi is running - - - - - - - - - - - - - - -");

		// - - - - - - - - - - - - - - - - - - - - OBJECTS CREATION
		LocalDate primaData = LocalDate.of(2023, 7, 1);
		Evento primoEvento = new Evento(1, "primoEvento", primaData, "primaDescrizione", TipoEvento.PRIVATO, 100);

		LocalDate secondaData = LocalDate.of(2023, 7, 1);
		Evento secondoEvento = new Evento(2, "secondoEvento", secondaData, "secondaDescrizione", TipoEvento.PRIVATO,
				100);

		LocalDate terzaData = LocalDate.of(2023, 7, 1);
		Evento terzoEvento = new Evento(3, "terzoEvento", terzaData, "terzaDescrizione", TipoEvento.PUBBLICO, 1000);

		Partecipazione primaPartecipazione = new Partecipazione(1, Stato.CONFERMATA);
		Partecipazione secondaPartecipazione = new Partecipazione(2, Stato.CONFERMATA);
		Partecipazione terzaPartecipazione = new Partecipazione(3, Stato.DA_CONFERMARE);

		Location primaLocation = new Location(1, "primaLocation", "Milano");
		Location secondaLocation = new Location(2, "secondaLocation", "Roma");
		Location terzaLocation = new Location(3, "terzaLocation", "Napoli");

		LocalDate primaPersonaData = LocalDate.of(1990, 8, 1);
		Persona primaPersona = new Persona(1, "Mario", "Rossi", "mario.rossi@mail.com", primaPersonaData,
				Sesso.MASCHIO);

		LocalDate secondaPersonaData = LocalDate.of(1990, 8, 1);
		Persona secondaPersona = new Persona(1, "Paolo", "Bianchi", "paolo.bianchi@mail.com", secondaPersonaData,
				Sesso.MASCHIO);

		LocalDate terzaPersonaData = LocalDate.of(1990, 8, 1);
		Persona terzaPersona = new Persona(1, "Giovanni", "Gianni", "giovanni.gianni@mail.com", terzaPersonaData,
				Sesso.MASCHIO);

		// - - - - - - - - - - - - - - - - - - - - DAO OBJECT CREATION
		EventoDAO eventoDao = new EventoDAO(entityManager);
		PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO(entityManager);

		// - - - - - - - - - - - - - - - - - - - - SAVE
		eventoDao.save(primoEvento);
		eventoDao.save(secondoEvento);
		eventoDao.save(terzoEvento);

		partecipazioneDao.save(primaPartecipazione);
		partecipazioneDao.save(secondaPartecipazione);
		partecipazioneDao.save(terzaPartecipazione);

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
