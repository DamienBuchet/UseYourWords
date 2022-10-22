package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.Partie;

@Repository
@Transactional
public class PartieRepository {
	
	@PersistenceContext
	private EntityManager em;

	public List<Partie> findAll() {
		return em.createQuery("select p from Partie p", Partie.class).getResultList();
	}
	
	public Optional<Partie> findById(int id)
	{
		return Optional.ofNullable(em.find(Partie.class, id));
	}
	
	@Transactional
	public Partie save(Partie entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from Partie p where p.id = ?1").setParameter(1, id).executeUpdate();
	}
}