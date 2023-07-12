package gestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

	// save
	// getById
	// delete
	// refresh

	private final EntityManager entityManager;

	public LocationDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Location _location) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_location);
		entityTransaction.commit();
		System.out.println("Location salvata correttamente");
	}

	public Location findById(long _id) {
		Location locationCercata = entityManager.find(Location.class, _id);
		return locationCercata;
	}

	public void findByIdAndDelete(long _id) {
		Location locationCercata = entityManager.find(Location.class, _id);
		if (locationCercata != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(locationCercata);
			entityTransaction.commit();

		} else {
			System.out.println("Location non trovata");
		}
	}

	public void refresh(long _id) {
		Location locationCercata = entityManager.find(Location.class, _id);

		locationCercata.setNome("REFRESH!");
		System.out.println("Location con refresh del nome:");
		System.out.println(locationCercata);

		entityManager.refresh(locationCercata);
		System.out.println("Evento con nome presente nel database:");
		System.out.println(locationCercata);

	}

}
