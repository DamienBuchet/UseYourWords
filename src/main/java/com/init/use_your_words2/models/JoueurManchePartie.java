package com.init.use_your_words2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JoueurManchePartie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50, nullable = false)
	private String motchoisi;
	
	@ManyToOne
	@JoinColumn(name = "joueurpartie_partie_id", nullable = false)
	private Partie partie;
	
	@ManyToOne
	@JoinColumn(name = "joueurpartie_manche_id", nullable = false)
	private Manche manche;
	
	@ManyToOne
	@JoinColumn(name = "joueurpartie_joueur_id", nullable = false)
	private Joueur joueur;
	
	@Column(length = 50, nullable = false)
	private int scoremanche;
}
