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
	public void shouldMapEntityWithoutSourceThumbnailToDTO() {
		// given
		Author author = mockAuthor(11L, "author name", "Warsjawa");
		Category category1 = mockCategory(10L, "nazwa testowa");
		Category category2 = mockCategory(12L, "nazwa testowa 2");
		Source source = mockSource(115L, "author name", null);
		
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
	
	@Test
	public void shouldMapEntityWithSourceThumbnailToDTO() {
		// given
		File thumbnail = mock(File.class);
		when(thumbnail.getId()).thenReturn(17L);
		when(thumbnail.getName()).thenReturn("thumbnail");
		when(thumbnail.getSize()).thenReturn(2561);
		
		Source source = mockSource(115L, "a(mockSourceuthor name", thumbnail);
		
		File file = mock(File.class);
		when(file.getId()).thenReturn(113L);
		when(file.getSource()).thenReturn(source);
		
		// when
		FileDTO dto = EntityToDtoMapperFactory.mapFileToDTO(file);
		
		// then
		assertNotNull(dto);
		assertEquals("DTO id should be same value.", file.getId(), dto.getId());
		assertEquals("DTO source should be same value.", file.getSource().getThumbnail().getSize(), dto.getSource().getThumbnail().getSize());
	}
	
	public Author mockAuthor(long id, String name, String city) {
		Author author = mock(Author.class);
		when(author.getId()).thenReturn(id);
		when(author.getName()).thenReturn(name);
		when(author.getCity()).thenReturn(city);
		return author;
	}
	
	public Category mockCategory(long id, String name) {
		Category category = mock(Category.class);
		when(category.getId()).thenReturn(id);
		when(category.getName()).thenReturn(name);
		return category;
	}
	
	public Source mockSource(long id, String name, File thumbnail) {
		Source source = mock(Source.class);
		when(source.getId()).thenReturn(id);
		when(source.getName()).thenReturn(name);
		when(source.getThumbnail()).thenReturn(thumbnail);
		return source;
	}
}