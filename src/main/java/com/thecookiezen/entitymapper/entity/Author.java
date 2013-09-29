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

	public Author() {
	}

	public Author(long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public Author (String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	public static Author createNewInstance(String name, String city) {
		return new Author(name, city);
	}
	
	public static Author createModifyingInstance(long id, String name, String city) {
		return new Author(id, name, city);
	}
	
	public void merge(Author author) {
		setName(author.getName());
		setCity(author.getCity());
		
		// some random logic
	}
}
