package pl.coderslab.charity.institution.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.charity.institution.domain.Institution;
import pl.coderslab.charity.institution.domain.InstitutionDTO;

import java.util.List;

@Mapper
public interface InstitutionMapper {

    InstitutionMapper INSTANCE = Mappers.getMapper(InstitutionMapper.class);

    InstitutionDTO toDTO(Institution entity);
    List<InstitutionDTO> toDTOList(List<Institution> entity);

    Institution fromDTO(InstitutionDTO dto);
    List<Institution> fromDTOList(List<InstitutionDTO> dto);

}
