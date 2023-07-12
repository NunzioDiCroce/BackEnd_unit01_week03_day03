package gestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {

	// save
	// getById
	// delete
	// refresh

	private final EntityManager entityManager;

	public PartecipazioneDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Partecipazione _partecipazione) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_partecipazione);
		entityTransaction.commit();
		System.out.println("Partecipazione salvata correttamente");
	}

	public Partecipazione findById(long _id) {
		Partecipazione partecipazioneCercata = entityManager.find(Partecipazione.class, _id);
		return partecipazioneCercata;
	}

	public void findByIdAndDelete(long _id) {
		Partecipazione partecipazioneCercata = entityManager.find(Partecipazione.class, _id);
		if (partecipazioneCercata != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(partecipazioneCercata);
			entityTransaction.commit();

		} else {
			System.out.println("Partecipazione non trovata");
		}
	}

	public void refresh(long _id) {
		Partecipazione partecipazioneCercata = entityManager.find(Partecipazione.class, _id);

		// partecipazioneCercata.setNome("REFRESH!");
		// System.out.println("Partecipazione con refresh del ... :");
		System.out.println(partecipazioneCercata);

		entityManager.refresh(partecipazioneCercata);
		// System.out.println("Partecipazione con ... presente nel database:");
		System.out.println(partecipazioneCercata);

	}

}
