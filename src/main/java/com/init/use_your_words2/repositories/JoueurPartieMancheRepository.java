package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.JoueurManchePartie;

@Repository
@Transactional
public class JoueurPartieMancheRepository {

	@PersistenceContext
	private EntityManager em;

	public List<JoueurManchePartie> findAll() {
		return em.createQuery("select j from JoueurManchePartie j", JoueurManchePartie.class).getResultList();
	}
	
	public Optional<JoueurManchePartie> findById(int id)
	{
		return Optional.ofNullable(em.find(JoueurManchePartie.class, id));
	}
	
	@Transactional
	public JoueurManchePartie save(JoueurManchePartie entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from JoueurManchePartie j where j.id = ?1").setParameter(1, id).executeUpdate();
	}
}
