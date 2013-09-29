package com.thecookiezen.entitymapper.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.Hibernate;

/**
 * @author nikom
 */
@Data
@Entity
public class File {
	
	@Id
	private long id;
	
	private String name;
	
	private List<Category> categories;
	
	private List<Author> authors;
	
	private Source source;
	
	private String url;
	
	private int size;
	
	private String tags;

	public File() {
	}
	
	public File(String name, List<Category> categories, List<Author> authors, Source source, String url, int size, String tags) {
		this.name = name;
		this.categories = categories;
		this.authors = authors;
		this.source = source;
		this.url = url;
		this.size = size;
		this.tags = tags;
	}
	
	public File(long id, String name, List<Category> categories, List<Author> authors, Source source, String url, int size, String tags) {
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.authors = authors;
		this.source = source;
		this.url = url;
		this.size = size;
		this.tags = tags;
	}
	
	public void setSource(@NonNull final Source source) {
		source.increment();
		this.source = source;
	}
	
	public static File createNewInstance(String name, List<Category> categories, List<Author> authors, Source source, String url, int size, String tags) {
		return new File(name, categories, authors, source, url, size, tags);
	}
	
	public static File createModifyingInstance(long id, String name, List<Category> categories, List<Author> authors, Source source, String url, int size, String tags) {
		return new File(id, name, categories, authors, source, url, size, tags);
	}
	
	public void initialize() {
		Hibernate.initialize(getAuthors());
		Hibernate.initialize(getSource());
		Hibernate.initialize(getCategories());
	}
	
	public void merge(File file) {
		// need merging ?
		setAuthors(getAuthors());
		setCategories(getCategories());
		
		setName(file.getName());
		setSource(file.getSource());
		setTags(file.getTags());
		setUrl(file.getUrl());
		
		// some random logic
	}
}
