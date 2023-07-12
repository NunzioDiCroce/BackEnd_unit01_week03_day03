package gestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {

	// save
	// getById
	// delete
	// refresh

	private final EntityManager entityManager;

	public PersonaDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Persona _persona) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_persona);
		entityTransaction.commit();
		System.out.println("Persona salvata correttamente");
	}

	public Persona findById(long _id) {
		Persona personaCercata = entityManager.find(Persona.class, _id);
		return personaCercata;
	}

	public void findByIdAndDelete(long _id) {
		Persona personaCercata = entityManager.find(Persona.class, _id);
		if (personaCercata != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(personaCercata);
			entityTransaction.commit();

		} else {
			System.out.println("Persona non trovata");
		}
	}

	public void refresh(long _id) {
		Persona personaCercata = entityManager.find(Persona.class, _id);

		personaCercata.setNome("REFRESH!");
		System.out.println("Persona con refresh del nome:");
		System.out.println(personaCercata);

		entityManager.refresh(personaCercata);
		System.out.println("Persona con nome presente nel database:");
		System.out.println(personaCercata);

	}

}
