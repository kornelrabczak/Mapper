package com.thecookiezen.entitymapper.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author nikom
 */
@Data
@Entity
public class Author {
	
	@Id
	private long id;
	
	private String name;
	
	private String city;

	public Author(long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
}
