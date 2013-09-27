package com.thecookiezen.entitymapper;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.thecookiezen.entitymapper.dto.query.AuthorDTO;
import com.thecookiezen.entitymapper.dto.query.CategoryDTO;
import com.thecookiezen.entitymapper.dto.query.FileDTO;
import com.thecookiezen.entitymapper.dto.query.SourceDTO;
import com.thecookiezen.entitymapper.entity.Author;
import com.thecookiezen.entitymapper.entity.Category;
import com.thecookiezen.entitymapper.entity.File;
import com.thecookiezen.entitymapper.entity.Source;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikom
 */
public class EntityToDtoMapperFactory {

	public static CategoryDTO mapCategegoryToDTO(Category category) {
		return new Mapper<Category, CategoryDTO>() {
			public CategoryDTO apply(Category src) {
				return new CategoryDTO(src.getId(), src.getName());
			}
		}.apply(category);
	}
	
	public static AuthorDTO mapAuthorToDTO(Author author) {
		return new Mapper<Author, AuthorDTO>() {
			public AuthorDTO apply(Author src) {
				return new AuthorDTO(src.getId(), src.getName(), src.getCity());
			}
		}.apply(author);
	}
	
	public static SourceDTO mapSourceToDTO(Source source) {
		return new Mapper<Source, SourceDTO>() {
			public SourceDTO apply(Source src) {
				return new SourceDTO(src.getId(), src.getName(), mapFileToDTO(src.getThumbnail()));
			}
		}.apply(source);
	}
	
	public static FileDTO mapFileToDTO(File file) {
		return new Mapper<File, FileDTO>() {
			public FileDTO apply(File src) {
				return new FileDTO(src.getId(), src.getName(), 
					Lists.transform(src.getCategories(), new Function<Category, CategoryDTO>() {
						public CategoryDTO apply(Category category) {
							return mapCategegoryToDTO(category);
						}
					}),
					null, mapSourceToDTO(src.getSource()),
					src.getUrl(), src.getSize(), src.getTags());
			}
		}.apply(file);
	}
}
