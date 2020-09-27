package pl.coderslab.charity.donation.domain;

import lombok.*;
import pl.coderslab.charity.category.domain.CategoryDTO;
import pl.coderslab.charity.institution.domain.InstitutionDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class DonationDTO {

    private Long id;
    private Integer quantity;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    private List<CategoryDTO> categories;

    private InstitutionDTO institution;
}
