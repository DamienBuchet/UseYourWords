package com.init.use_your_words2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Manche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.ORDINAL)
	private TypeManche typeManche;
	
	@OneToMany(mappedBy = "manche")
	private List<Proposition> proposition;
	
	@ManyToOne
	@JoinColumn(name = "manche_partie_id", nullable = false)
	private Partie partie;

}