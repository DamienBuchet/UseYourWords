package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.Partie;
import com.init.use_your_words2.models.Proposition;

@Repository
@Transactional
public class PropositionRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List<Proposition> findAll() {
		return em.createQuery("select p from Proposition p", Proposition.class).getResultList();
	}
	
	public Optional<Proposition> findById(int id)
	{
		return Optional.ofNullable(em.find(Proposition.class, id));
	}
	
	@Transactional
	public Proposition save(Proposition entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from Proposition p where p.id = ?1").setParameter(1, id).executeUpdate();
	}

}
