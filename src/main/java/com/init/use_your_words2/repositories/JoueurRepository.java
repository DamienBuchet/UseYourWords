package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.Joueur;
import com.init.use_your_words2.models.Partie;

@Repository
@Transactional
public class JoueurRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List<Joueur> findAll() {
		return em.createQuery("select j from Joueur j", Joueur.class).getResultList();
	}
	
	public Optional<Joueur> findById(int id)
	{
		return Optional.ofNullable(em.find(Joueur.class, id));
	}
	
	@Transactional
	public Joueur save(Joueur entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from Produit p where p.id = ?1").setParameter(1, id).executeUpdate();
	}
	
	@Transactional
	public void UpdateJoueurAfterMancheTerminée(int compteur, Partie partie, String nom)
	{
		
		em.createQuery("update Joueur j set j.score = j.score + ?1 where j.partie = ?2 and j.name = ?3")
		.setParameter(1, compteur)
		.setParameter(2, partie)
		.setParameter(3, nom).executeUpdate();
	}

}