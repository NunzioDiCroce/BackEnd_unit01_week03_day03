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
		System.out.println("");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - eventoDAO.save");
		System.out.println("");
		// eventoDao.save(primoEvento);
		eventoDao.save(secondoEvento);
		// eventoDao.save(terzoEvento);

		System.out.println("");
		System.out.println("Nel database sono stati salvati i seguenti oggetti:");
		System.out.println(primoEvento);
		System.out.println(secondoEvento);
		System.out.println(terzoEvento);

		// - - - - - - - - - - - - - - - - - - - - FIND BY ID
		System.out.println("");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - eventoDAO.findById");
		System.out.println("");
		Evento eventoCercato = eventoDao.findById(1);
		System.out.println("Nel database è presente il seguente oggetto con id = " + eventoCercato.getId());
		System.out.println(eventoCercato);

		// - - - - - - - - - - - - - - - - - - - - FIND BY ID AND DELETE

		Evento eventoDaCancellare = eventoDao.findById(2);

		System.out.println("");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - eventoDAO.findByIdAndDelete");
		System.out.println("");
		eventoDao.findByIdAndDelete(2);
		System.out
				.println("Nel database è stato cancellato il seguente oggetto con id = " + eventoDaCancellare.getId());
		System.out.println(eventoDaCancellare);

		// - - - - - - - - - - - - - - - - - - - - REFRESH
		System.out.println("");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - eventoDAO.findByIdAndDelete");
		System.out.println("");
		eventoDao.refresh(3);

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
