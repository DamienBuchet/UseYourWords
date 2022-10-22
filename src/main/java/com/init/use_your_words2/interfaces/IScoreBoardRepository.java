package com.init.use_your_words2.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.use_your_words2.models.ScoreBoard;

public interface IScoreBoardRepository extends JpaRepository<ScoreBoard, Integer> {

	@Query(nativeQuery = true, value = "select top 100 score_board.scoretotal, joueur.name from score_board inner join joueur on joueur.id = score_board.scoreboard_joueur_id order by score_board.scoretotal desc")
	public List<ScoreBoard> findAllTriéParScore();
}
