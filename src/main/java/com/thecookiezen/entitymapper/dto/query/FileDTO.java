package com.thecookiezen.entitymapper.dto.query;

import java.util.List;
import lombok.Data;

/**
 * @author nikom
 */
@Data
public class FileDTO {
	private long id;
	
	private String name;
	
	private List<CategoryDTO> categories;
	
	private List<AuthorDTO> authors;
	
	private SourceDTO source;
	
	private String url;
	
	private int size;
	
	private String tags;

	public FileDTO(long id, String name, List<CategoryDTO> categories, List<AuthorDTO> authors, SourceDTO source, String url, int size, String tags) {
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.authors = authors;
		this.source = source;
		this.url = url;
		this.size = size;
		this.tags = tags;
	}
}
