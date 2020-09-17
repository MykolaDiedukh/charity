package pl.coderslab.charity.donation.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.charity.donation.domain.Donation;
import pl.coderslab.charity.donation.domain.DonationDTO;

import java.util.List;

@Mapper
public interface DonationMapper {

    DonationMapper INSTANCE = Mappers.getMapper(DonationMapper.class);

    DonationDTO toDTO(Donation entity);

    List<DonationDTO> toDTOList(List<Donation> entity);

    Donation fromDTO(DonationDTO dto);

    List<Donation> fromDTOList(List<DonationDTO> dto);

}
