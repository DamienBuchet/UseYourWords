package com.init.use_your_words2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.init.use_your_words2.models.Joueur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proposition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = true)
	private int vote;
	
	@ManyToOne
	@JoinColumn(name = "proposition_manche_id", nullable = false)
	private Manche manche;
	
	@ManyToOne
	@JoinColumn(name = "proposition_joueur_id", nullable = false)
	private Joueur joueur;

	public Proposition(int vote, Manche manche, Joueur joueur) {
		super();
		this.vote = vote;
		this.manche = manche;
		this.joueur = joueur;
	}
	
}