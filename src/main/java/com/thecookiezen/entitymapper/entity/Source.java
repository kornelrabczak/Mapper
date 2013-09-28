package com.thecookiezen.entitymapper.entity;

import lombok.Data;

/**
 * @author nikom
 */
@Data
public class Source {
	
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
