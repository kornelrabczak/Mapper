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
}
