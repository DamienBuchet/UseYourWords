package com.init.use_your_words2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum TypeManche {

	sub_the_title, news_your_words, blankomatic;
	
	
	public static TypeManche getRandom()
	{
		return values()[ (int) (Math.random() * values().length)];
	}
}