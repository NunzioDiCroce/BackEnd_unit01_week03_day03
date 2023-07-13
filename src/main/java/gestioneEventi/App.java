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

		Evento primoEvento = new Evento(1, "primoEvento", LocalDate.of(2023, 7, 1), "primaDescrizione",
				TipoEvento.PRIVATO, 100);

		Evento secondoEvento = new Evento(2, "secondoEvento", LocalDate.of(2023, 7, 1), "secondaDescrizione",
				TipoEvento.PRIVATO, 100);

		Evento terzoEvento = new Evento(3, "terzoEvento", LocalDate.of(2023, 7, 1), "terzaDescrizione",
				TipoEvento.PUBBLICO, 1000);

		Partecipazione primaPartecipazione = new Partecipazione(1, Stato.CONFERMATA);
		Partecipazione secondaPartecipazione = new Partecipazione(2, Stato.CONFERMATA);
		Partecipazione terzaPartecipazione = new Partecipazione(3, Stato.DA_CONFERMARE);

		Location primaLocation = new Location(1, "primaLocation", "Milano");
		Location secondaLocation = new Location(2, "secondaLocation", "Roma");
		Location terzaLocation = new Location(3, "terzaLocation", "Napoli");

		Persona primaPersona = new Persona(1, "Mario", "Rossi", "mario.rossi@mail.com", LocalDate.of(1990, 8, 1),
				Sesso.MASCHIO);

		Persona secondaPersona = new Persona(2, "Paolo", "Bianchi", "paolo.bianchi@mail.com", LocalDate.of(1990, 8, 1),
				Sesso.MASCHIO);

		Persona terzaPersona = new Persona(3, "Giovanni", "Gianni", "giovanni.gianni@mail.com",
				LocalDate.of(1990, 8, 1), Sesso.MASCHIO);

		// - - - - - - - - - - - - - - - - - - - - DAO OBJECT CREATION
		EventoDAO eventoDao = new EventoDAO(entityManager);
		PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO(entityManager);
		LocationDAO locationDao = new LocationDAO(entityManager);
		PersonaDAO personaDao = new PersonaDAO(entityManager);

		// - - - - - - - - - - - - - - - - - - - - SAVE
//		eventoDao.save(primoEvento);
//		eventoDao.save(secondoEvento);
//		eventoDao.save(terzoEvento);
//
//		partecipazioneDao.save(primaPartecipazione);
//		partecipazioneDao.save(secondaPartecipazione);
//		partecipazioneDao.save(terzaPartecipazione);
//
//		locationDao.save(primaLocation);
//		locationDao.save(secondaLocation);
//		locationDao.save(terzaLocation);
//
//		personaDao.save(primaPersona);
//		personaDao.save(secondaPersona);
//		personaDao.save(terzaPersona);

		// primoEvento.setLocation(primaLocation);
		// eventoDao.save(primoEvento);

		secondoEvento.setLocation(secondaLocation);
		eventoDao.save(secondoEvento);

		terzoEvento.setLocation(terzaLocation);
		eventoDao.save(terzoEvento);

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
