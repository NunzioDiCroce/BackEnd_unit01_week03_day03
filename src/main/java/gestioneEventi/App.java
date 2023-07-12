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
		// public Evento(String _titolo, LocalDate _dataEvento, String _descrizione,
		// TipoEvento _tipoEvento,
		// int _numeroMassimoPartecipanti)
		LocalDate primaData = LocalDate.of(2023, 7, 1);
		Evento primoEvento = new Evento(1, "primoEvento", primaData, "primaDescrizione", TipoEvento.PRIVATO, 100);

		LocalDate secondaData = LocalDate.of(2023, 7, 1);
		Evento secondoEvento = new Evento(2, "secondoEvento", secondaData, "secondaDescrizione", TipoEvento.PRIVATO,
				100);

		LocalDate terzaData = LocalDate.of(2023, 7, 1);
		Evento terzoEvento = new Evento(3, "terzoEvento", terzaData, "terzaDescrizione", TipoEvento.PUBBLICO, 1000);

		LocalDate quartaData = LocalDate.of(2023, 7, 1);
		Evento quartoEvento = new Evento(4, "quartoEvento", quartaData, "quartaDescrizione", TipoEvento.PUBBLICO, 2000);

		LocalDate quintaData = LocalDate.of(2023, 7, 1);
		Evento quintoEvento = new Evento(5, "quintiEvento", quintaData, "quintaDescrizione", TipoEvento.PUBBLICO, 3000);

		// - - - - - - - - - - - - - - - - - - - - DAO OBJECT CREATION
		EventoDAO eventoDao = new EventoDAO(entityManager);

		// - - - - - - - - - - - - - - - - - - - - SAVE
		System.out.println("");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - eventoDAO.save");
		System.out.println("");
		// eventoDao.save(primoEvento); da inibire perché già salvato nel db
		eventoDao.save(secondoEvento);
		// eventoDao.save(terzoEvento); da inibire perché già salvato nel db
		// eventoDao.save(quartoEvento); da inibire perché già salvato nel db
		// eventoDao.save(quintoEvento); da inibire perché già salvato nel db
		System.out.println("");
		System.out.println("Nel database sono stati salvati i seguenti oggetti:");
		System.out.println(primoEvento);
		System.out.println(secondoEvento);
		System.out.println(terzoEvento);
		System.out.println(quartoEvento);
		System.out.println(quintoEvento);

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
