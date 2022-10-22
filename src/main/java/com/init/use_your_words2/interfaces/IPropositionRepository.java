package com.init.use_your_words2.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.use_your_words2.models.Proposition;

public interface IPropositionRepository extends JpaRepository<Proposition, Integer> {

	@Query(nativeQuery = true, value = "select top 1 * from proposition order by id desc")
	public Proposition findLastProposition();
}
