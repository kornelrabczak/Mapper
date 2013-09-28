package com.thecookiezen.entitymapper.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author nikom
 */
@Data
@Entity
public class Source {
	
	@Id
	private long id;
	
	private String name;
	
	private File thumbnail;
	
	private int counter;
	
	public void increment() {
		counter++;
	}
	
	public void decrement() {
		counter--;
	}
	
}
