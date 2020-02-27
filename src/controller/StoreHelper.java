package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.StoreDetails;

public class StoreHelper {

	static	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameList");

	public void insertStore(StoreDetails st) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(st);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<StoreDetails> showAllStores() {
		
		EntityManager em = emfactory.createEntityManager();
		List<StoreDetails> allStores = em.createQuery("SELECT i FROM StoreDetails i").getResultList();
		
		return allStores;	
	}
	
	public void deleteStore(StoreDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<StoreDetails> typedQuery = em.createQuery("select li from StoreDetails li where li.storeName = :selectedStore", StoreDetails.class);
		
		//Substitute parameter with actual data	from the toDelete item
		typedQuery.setParameter("selectedStore", toDelete.getStoreName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		StoreDetails result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	public StoreDetails searchForStoreById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		StoreDetails found = em.find(StoreDetails.class, idToEdit);
		
		em.close();
		
		return found;
	}

	public void updateStore(StoreDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		
		em.getTransaction().commit();
		em.close();
		
	}

	public List<StoreDetails> searchForStoreByName(String gameName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<StoreDetails> typedQuery = em.createQuery("select li	from StoreDetails li where li.name = :selectedStore", StoreDetails.class);
		typedQuery.setParameter("selectedStore", gameName);
		List<StoreDetails> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return	foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
		}
	
}
