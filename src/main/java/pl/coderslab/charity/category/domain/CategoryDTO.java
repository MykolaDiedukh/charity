package pl.coderslab.charity.category.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class CategoryDTO {

    private Long id;
    private String name;

}
