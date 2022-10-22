package com.init.use_your_words2.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Joueur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private int score;
	
	@ManyToOne
	@JoinColumn(name = "joueur_equipe_id", nullable = false)
	private Equipe equipe;
	
	@ManyToOne
	@JoinColumn(name = "joueur_partie_id", nullable = false)
	private Partie partie;

	@OneToMany(mappedBy = "joueur")
	private List<JoueurManchePartie> joueursparties;
}