package com.thecookiezen.entitymapper.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.Hibernate;

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

	public Source() {
	}

	public Source(String name, File thumbnail) {
		this.name = name;
		this.thumbnail = thumbnail;
	}
	
	public Source(long id, String name, File thumbnail) {
		this.id = id;
		this.name = name;
		this.thumbnail = thumbnail;
	}
	
	public void increment() {
		counter++;
	}
	
	public void decrement() {
		counter--;
	}
	
	public static Source createNewInstance(String name, File thumbnail) {
		return new Source(name, thumbnail);
	}
	
	public static Source createModifyingInstance(long id, String name, File thumbnail) {
		return new Source(id, name, thumbnail);
	}
	
	public void initialize() {
		Hibernate.initialize(getThumbnail());
	}
	
	public void merge(Source source) {
		setName(source.getName());
		setThumbnail(source.getThumbnail());
		
		// some random logic
	}
}
