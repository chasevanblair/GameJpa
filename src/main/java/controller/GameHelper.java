/**
 * @author Chase Van Blair - crvanblair
 * CIS175 - Fall 2021
 * Feb 2, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameObj;

public class GameHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameJPA");
	
	public void addGame(GameObj g) {
		//TODO check that game doesn't already exist
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delGame(GameObj g) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<GameObj> typedQuery = 
				em.createQuery("select g from GameObj g where g.title = "
						+ ":gameTitle", GameObj.class); 

		typedQuery.setParameter("gameTitle", g.getTitle()); 

		typedQuery.setMaxResults(1); 

		//get result for use
		GameObj result = typedQuery.getSingleResult(); 

		//delete
		em.remove(result); 
		em.getTransaction().commit(); 
		em.close(); 
	}
	
	public void editGame(GameObj g) {
		//new data for game is passed already as g
		GameObj temp = g;
		delGame(g);
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
	    em.merge(temp);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public List<GameObj> getAllGames() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		List<GameObj> typedQuery = em.createQuery("SELECT g FROM GameObj g", GameObj.class).getResultList();
		return typedQuery;
	}
	
	public List<GameObj> getGame(String title){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GameObj> typedQuery = em.createQuery("SELECT g FROM GameObj g WHERE g.title = :gameTitle", GameObj.class);
		typedQuery.setParameter("gameTitle", title);
		
		List<GameObj> foundGame = typedQuery.getResultList();
		em.close();
		return foundGame;
	}
	
	public void cleanup() {
		emfactory.close();
	}
	

}
