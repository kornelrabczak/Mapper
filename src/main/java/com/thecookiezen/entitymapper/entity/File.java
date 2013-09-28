package com.thecookiezen.entitymapper.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NonNull;

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
	
	public void setSource(@NonNull final Source source) {
		source.increment();
		this.source = source;
	}
}
