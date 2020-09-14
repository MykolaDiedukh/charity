package pl.coderslab.charity.donation.domain;

import lombok.*;
import pl.coderslab.charity.category.domain.Category;
import pl.coderslab.charity.institution.domain.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalDate pickUpTime;
    private String pickUpComment;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Category> categories;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Institution institution;
}
