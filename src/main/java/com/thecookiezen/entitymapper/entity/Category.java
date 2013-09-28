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
}
