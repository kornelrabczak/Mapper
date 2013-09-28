package com.thecookiezen.entitymapper;

import com.thecookiezen.entitymapper.dto.query.AuthorDTO;
import com.thecookiezen.entitymapper.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author nikom
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorEntityToDtoTest {
	
	@Test
	public void shouldMapEmptyEntityToDTO() {
		// given
		Author author = mock(Author.class);
		
		// when
		AuthorDTO dto = EntityToDtoMapperFactory.mapAuthorToDTO(author);
		
		// then
		assertNotNull(dto);
	}
	
	@Test
	public void shouldMapEntityToDTO() {
		// given
		Author author = mock(Author.class);
		when(author.getId()).thenReturn(11L);
		when(author.getName()).thenReturn("author name");
		when(author.getCity()).thenReturn("Warsjawa");
		
		// when
		AuthorDTO dto = EntityToDtoMapperFactory.mapAuthorToDTO(author);
		
		// then
		assertNotNull(dto);
		assertEquals("DTO id should be same value.", author.getId(), dto.getId());
		assertEquals("DTO name should be same value.", author.getName(), dto.getName());
		assertEquals("DTO city should be same value.", author.getCity(), dto.getCity());
	}
}