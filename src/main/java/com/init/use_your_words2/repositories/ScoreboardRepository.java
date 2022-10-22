package com.init.use_your_words2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.init.use_your_words2.models.Partie;
import com.init.use_your_words2.models.Proposition;
import com.init.use_your_words2.models.ScoreBoard;

@Repository
@Transactional
public class ScoreboardRepository {

	@PersistenceContext
	private EntityManager em;

	public List<ScoreBoard> findAll() {
		return em.createQuery("select s from ScoreBoard s", ScoreBoard.class).getResultList();
	}
	
	public Optional<ScoreBoard> findById(int id)
	{
		return Optional.ofNullable(em.find(ScoreBoard.class, id));
	}
	
	@Transactional
	public ScoreBoard save(ScoreBoard entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public void deleteById(int id)
	{
		em.createQuery("delete from ScoreBoard s where s.id = ?1").setParameter(1, id).executeUpdate();
	}
	
	@Transactional
	public void UpdateScoreBoardAfterPartieTerminée(int score, int id)
	{
		
		em.createQuery("update ScoreBoard s set s.scoretotal = s.scoretotal + ?1 where s.id = ?2")
		.setParameter(1, score)
		.setParameter(2, id).executeUpdate();
	}
}
