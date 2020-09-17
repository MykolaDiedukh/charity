package pl.coderslab.charity.category.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.charity.category.domain.Category;
import pl.coderslab.charity.category.domain.CategoryDTO;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDto(Category entity);
    List<CategoryDTO> toDTOList(List<Category> entity);

    Category categoryDtoToCategory(CategoryDTO dto);
    List<Category> fromDTOList(List<CategoryDTO> dto);
}
