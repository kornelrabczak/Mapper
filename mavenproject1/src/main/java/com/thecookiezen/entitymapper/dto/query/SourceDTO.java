package com.thecookiezen.entitymapper.dto.query;

import lombok.Data;

/**
 * @author nikom
 */
@Data
public class SourceDTO {
	private long id;
	
	private String name;
	
	private FileDTO thumbnail;
}
