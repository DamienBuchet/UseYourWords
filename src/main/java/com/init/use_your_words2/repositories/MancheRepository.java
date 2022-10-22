package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.Manche;

@Repository
@Transactional
public class MancheRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Manche> findAll() {
		return em.createQuery("select m from Manche m", Manche.class).getResultList();
	}
	
	public Optional<Manche> findById(int id)
	{
		return Optional.ofNullable(em.find(Manche.class, id));
	}
	
	@Transactional
	public Manche save(Manche entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from Manche m where m.id = ?1").setParameter(1, id).executeUpdate();
	}
}
