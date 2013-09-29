package com.thecookiezen.entitymapper;

import com.google.common.base.Function;
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
import java.util.List;

/**
 * @author nikom
 */
public class DtoToEntityMapperFactory {
	
	public static Category mapModifyCategegoryToEntity(final CategoryDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return new Mapper<CategoryDTO, Category>() {
			public Category apply(CategoryDTO src) {
				return Category.createModifyingInstance(src.getId(), src.getName());
			}
		}.apply(dto);
	}
	
	public static Category mapCreateCategoryToEntity(final CategoryDTO dto) {
		return new Mapper<CategoryDTO, Category>() {
			public Category apply(CategoryDTO src) {
				return Category.createNewInstance(src.getName());
			}
		}.apply(dto);
	}
	
	public static Author mapModifyAuthorToEntity(final AuthorDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return new Mapper<AuthorDTO, Author>() {
			public Author apply(AuthorDTO src) {
				return Author.createModifyingInstance(src.getId(), src.getName(), src.getCity());
			}
		}.apply(dto);
	}
	
	public static Author mapCreateAuthorToEntity(final AuthorDTO dto) {
		return new Mapper<AuthorDTO, Author>() {
			public Author apply(AuthorDTO src) {
				return Author.createNewInstance(src.getName(), src.getCity());
			}
		}.apply(dto);
	}
	
	public static Source mapCreateSourceToEntity(final SourceDTO dto) {
		return new Mapper<SourceDTO, Source>() {
			public Source apply(SourceDTO src) {
				return Source.createNewInstance(src.getName(), mapModifyFileToEntity(src.getThumbnail()));
			}
		}.apply(dto);
	}
	
	public static Source mapModifySourceToEntity(final SourceDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return new Mapper<SourceDTO, Source>() {
			public Source apply(SourceDTO src) {
				return Source.createModifyingInstance(src.getId(), src.getName(), mapModifyFileToEntity(src.getThumbnail()));
			}
		}.apply(dto);
	}
	
	public static File mapModifyFileToEntity(final FileDTO dto) {
		checkArgument(dto.getId() > 0, "Modify DTO should have id > 0");
		return new Mapper<FileDTO, File>() {
			public File apply(FileDTO src) {
				return File.createModifyingInstance(src.getId(), src.getName(),
					categoriesToEntity(src.getCategories()), 
					authorsToEntity(src.getAuthors()),
					mapCreateSourceToEntity(src.getSource()),
					src.getUrl() ,src.getSize(), src.getTags());
			}
		}.apply(dto);
	}
	
	public static File mapCreateFileToEntity(final FileDTO dto) {
		checkArgument(dto.getSource().getId() > 0, "Modify DTO should have id > 0");
		return new Mapper<FileDTO, File>() {
			public File apply(FileDTO src) {
				return File.createNewInstance(src.getName(),
					categoriesToEntity(src.getCategories()), 
					authorsToEntity(src.getAuthors()),
					mapCreateSourceToEntity(src.getSource()), src.getUrl() ,src.getSize(), src.getTags());
			}
		}.apply(dto);
	}
	
	public static List<Category> categoriesToEntity(List<CategoryDTO> categories) {
		return Lists.transform(categories, new Function<CategoryDTO, Category>() {
			public Category apply(CategoryDTO category) {
				return mapModifyCategegoryToEntity(category);
			}
		});
	}
	
	public static List<Author> authorsToEntity(List<AuthorDTO> authors) {
		return Lists.transform(authors, new Function<AuthorDTO, Author>() {
			public Author apply(AuthorDTO author) {
				return mapModifyAuthorToEntity(author);
			}
		});
	}
}
