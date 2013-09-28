package com.thecookiezen.entitymapper;

import com.thecookiezen.entitymapper.dto.query.CategoryDTO;
import com.thecookiezen.entitymapper.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author nikom
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryEntityToDtoTest {
	
	@Test
	public void shouldMapEmptyEntityToDTO() {
		// given
		Category category = mock(Category.class);
		
		// when
		CategoryDTO dto = EntityToDtoMapperFactory.mapCategegoryToDTO(category);
		
		// then
		assertNotNull(dto);
	}
	
	@Test
	public void shouldMapEntityToDTO() {
		// given
		Category category = mock(Category.class);
		when(category.getId()).thenReturn(10L);
		when(category.getName()).thenReturn("nazwa testowa");
		
		// when
		CategoryDTO dto = EntityToDtoMapperFactory.mapCategegoryToDTO(category);
		
		// then
		assertNotNull(dto);
		assertEquals("DTO id should be same value.", category.getId(), dto.getId());
		assertEquals("DTO name should be same value.", category.getName(), dto.getName());
	}
}