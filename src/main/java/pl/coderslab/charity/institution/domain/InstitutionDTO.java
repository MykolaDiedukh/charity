package pl.coderslab.charity.institution.domain;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class InstitutionDTO {

    private Long id;
    private String name;
    private String description;
}
