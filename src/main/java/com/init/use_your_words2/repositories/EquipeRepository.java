package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.Equipe;
import com.init.use_your_words2.models.Joueur;

@Repository
@Transactional
public class EquipeRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Equipe> findAll() {
		return em.createQuery("select e from Equipe e", Equipe.class).getResultList();
	}
	
	public Optional<Equipe> findById(int id)
	{
		return Optional.ofNullable(em.find(Equipe.class, id));
	}
	
	@Transactional
	public Equipe save(Equipe entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from Equipe p where p.id = ?1").setParameter(1, id).executeUpdate();
	}
}
