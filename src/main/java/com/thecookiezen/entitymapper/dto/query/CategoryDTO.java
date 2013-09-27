package com.thecookiezen.entitymapper.dto.query;

import lombok.Data;

/**
 * @author nikom
 */
@Data
public class CategoryDTO {
	private long id;
	
	private String name;

	public CategoryDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}
}
