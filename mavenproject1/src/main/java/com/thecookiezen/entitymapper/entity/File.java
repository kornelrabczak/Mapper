package com.thecookiezen.entitymapper.entity;

import java.util.List;
import lombok.Data;

/**
 * @author nikom
 */
@Data
public class File {
	
	private long id;
	
	private String name;
	
	private List<Category> categories;
	
	private List<Author> authors;
	
	private Source source;
	
	private String url;
	
	private int size;
	
	private String tags;
}
