package com.thecookiezen.entitymapper.dto.query;

import lombok.Data;

/**
 * @author nikom
 */
@Data
public class AuthorDTO {
	private long id;
	
	private String name;
	
	private String city;

	public AuthorDTO(long id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
}
