package com.thecookiezen.entitymapper.repository;

import com.thecookiezen.entitymapper.DtoToEntityMapperFactory;
import com.thecookiezen.entitymapper.EntityToDtoMapperFactory;
import com.thecookiezen.entitymapper.dto.query.FileDTO;
import com.thecookiezen.entitymapper.entity.File;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author nikom
 */
public class SomeRandomRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public FileDTO updateFile(FileDTO dto) {
		// load entity to persistence context
		File old = em.find(File.class, dto.getId());
		// initialize not primitive types, load to persistence context
		old.initialize();
		
		// map dto to entity type
		File newFile = DtoToEntityMapperFactory.mapModifyFileToEntity(dto);
		
		// merge new entity
		old.merge(newFile);
		
		return EntityToDtoMapperFactory.mapFileToDTO(old);
	}
	
	public FileDTO createFile(FileDTO dto) {
		File file = DtoToEntityMapperFactory.mapCreateFileToEntity(dto);
		em.persist(file);
		return EntityToDtoMapperFactory.mapFileToDTO(file);
	}
}
