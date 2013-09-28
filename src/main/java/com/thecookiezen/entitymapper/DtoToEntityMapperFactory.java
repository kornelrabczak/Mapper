package com.thecookiezen.entitymapper;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.thecookiezen.entitymapper.dto.query.CategoryDTO;
import com.thecookiezen.entitymapper.entity.Category;

import static com.google.common.base.Preconditions.*;
import com.google.common.collect.Lists;
import com.thecookiezen.entitymapper.dto.query.AuthorDTO;
import com.thecookiezen.entitymapper.dto.query.FileDTO;
import com.thecookiezen.entitymapper.dto.query.SourceDTO;
import com.thecookiezen.entitymapper.entity.Author;
import com.thecookiezen.entitymapper.entity.File;
import com.thecookiezen.entitymapper.entity.Source;
import java.util.ArrayList;

/**
 * @author nikom
 */
public class DtoToEntityMapperFactory {
	
	public static Category mapModifyCategegoryToEntity(final CategoryDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return mapCreateCategoryToEntity(dto);
	}
	
	public static Category mapCreateCategoryToEntity(final CategoryDTO dto) {
		return new Mapper<CategoryDTO, Category>() {
			public Category apply(CategoryDTO src) {
				return new Category(src.getId(), src.getName());
			}
		}.apply(dto);
	}
	
	public static Author mapModifyAuthorToEntity(final AuthorDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return mapCreateAuthorToEntity(dto);
	}
	
	public static Author mapCreateAuthorToEntity(final AuthorDTO dto) {
		return new Mapper<AuthorDTO, Author>() {
			public Author apply(AuthorDTO src) {
				return new Author(src.getId(), src.getName(), src.getCity());
			}
		}.apply(dto);
	}
	
	public static Source mapCreateSourceToEntity(final SourceDTO dto) {
		// todo logic
		return new Source();
	}
	
	public static File mapModifyFileToEntity(final FileDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return mapCreateFileToEntity(dto);
	}
	
	public static File mapCreateFileToEntity(final FileDTO dto) {
		checkArgument(dto.getSource().getId() > 0, "Modify DTO should have id > 0");
		// walidujemy wazne pola, ktore nie moga byc nullami
		return new Mapper<FileDTO, File>() {
			public File apply(FileDTO source) {
				File file = new File();
				file.setId(source.getId());
				file.setName(source.getName());
				file.setSize(source.getSize());
				file.setTags(source.getTags());
				file.setUrl(source.getTags());
				file.setAuthors(Lists.transform(Optional.fromNullable(source.getAuthors()).or(new ArrayList<AuthorDTO>()), new Function<AuthorDTO, Author>() {
					public Author apply(AuthorDTO author) {
						return mapCreateAuthorToEntity(author);
					}
				}));
				file.setCategories(Lists.transform(Optional.fromNullable(source.getCategories()).or(new ArrayList<CategoryDTO>()), new Function<CategoryDTO, Category>() {
					public Category apply(CategoryDTO category) {
						return mapCreateCategoryToEntity(category);
					}
				}));
				file.setSource(mapCreateSourceToEntity(source.getSource()));
				return file;
			}
		}.apply(dto);
	}
}
