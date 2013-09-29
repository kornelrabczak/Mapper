package com.thecookiezen.entitymapper.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author nikom
 */
@Data
@Entity
public class Category {
	
	@Id
	private long id;
	
	private String name;

	public Category() {
	}
	
	public Category(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public static Category createNewInstance(String name) {
		return new Category(name);
	}
	
	public static Category createModifyingInstance(long id, String name) {
		return new Category(id, name);
	}
	
	public void Category(Category category) {
		setName(category.getName());
		
		// some random logic
	}
}
