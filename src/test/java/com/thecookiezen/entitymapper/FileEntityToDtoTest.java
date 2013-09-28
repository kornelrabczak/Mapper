package com.thecookiezen.entitymapper;

import com.thecookiezen.entitymapper.dto.query.FileDTO;
import com.thecookiezen.entitymapper.entity.Author;
import com.thecookiezen.entitymapper.entity.Category;
import com.thecookiezen.entitymapper.entity.File;
import com.thecookiezen.entitymapper.entity.Source;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author nikom
 */
@RunWith(MockitoJUnitRunner.class)
public class FileEntityToDtoTest {
	
	@Test
	public void shouldMapEmptyEntityToDTO() {
		// given
		File file = mock(File.class);
		
		// when
		FileDTO dto = EntityToDtoMapperFactory.mapFileToDTO(file);
		
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
		
		File thumbnail = mock(File.class);
		when(thumbnail.getId()).thenReturn(17L);
		when(thumbnail.getName()).thenReturn("thumbnail");
		when(thumbnail.getSize()).thenReturn(2561);
		
		Source source = mock(Source.class);
		when(source.getId()).thenReturn(115L);
		when(source.getName()).thenReturn("author name");
//		when(source.getThumbnail()).thenReturn(thumbnail);
		
		Category category1 = mock(Category.class);
		when(category1.getId()).thenReturn(10L);
		when(category1.getName()).thenReturn("nazwa testowa");
		
		Category category2 = mock(Category.class);
		when(category2.getId()).thenReturn(12L);
		when(category2.getName()).thenReturn("nazwa testowa 2");
		
		File file = mock(File.class);
		when(file.getId()).thenReturn(13L);
		when(file.getName()).thenReturn("zdjecie z wakacji");
		when(file.getSize()).thenReturn(256);
		when(file.getTags()).thenReturn("zdjecia, wakacje, fotografia");
		when(file.getUrl()).thenReturn("http://xyz.pl/test.jpg");
		when(file.getAuthors()).thenReturn(Arrays.asList(author));
		when(file.getCategories()).thenReturn(Arrays.asList(category1, category2));
		when(file.getSource()).thenReturn(source);
		
		// when
		FileDTO dto = EntityToDtoMapperFactory.mapFileToDTO(file);
		
		// then
		assertNotNull(dto);
		assertEquals("DTO id should be same value.", file.getId(), dto.getId());
		assertEquals("DTO name should be same value.", file.getName(), dto.getName());
		assertEquals("DTO size should be same value.", file.getSize(), dto.getSize());
		assertEquals("DTO tags should be same value.", file.getTags(), dto.getTags());
		assertEquals("DTO url should be same value.", file.getUrl(), dto.getUrl());
		assertEquals("DTO url should be same value.", file.getAuthors().get(0).getCity(), dto.getAuthors().get(0).getCity());
		assertEquals("DTO categories should be same value.", file.getCategories().get(0).getName(), dto.getCategories().get(0).getName());
		assertEquals("DTO source should be same value.", file.getSource().getId(), dto.getSource().getId());
	}
}