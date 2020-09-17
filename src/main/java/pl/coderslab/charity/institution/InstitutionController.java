package pl.coderslab.charity.institution;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.institution.converter.InstitutionMapper;
import pl.coderslab.charity.institution.domain.InstitutionDTO;

import java.util.List;

@Controller
@RequestMapping("/institution")
class InstitutionController {

    private final InstitutionService institutionService;

    InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public List<InstitutionDTO> findAll() {
        return InstitutionMapper
                .INSTANCE
                .toDTOList(institutionService.findAll());
    }

    @GetMapping("/{id}")
    public InstitutionDTO findById(@PathVariable Long id) {
        return InstitutionMapper
                .INSTANCE
                .toDTO(institutionService.findById(id));
    }

    @PostMapping
    public Long create(@RequestBody InstitutionDTO institutionDTO) {
        return institutionService.create(InstitutionMapper
                .INSTANCE
                .fromDTO(institutionDTO));
    }

    @PutMapping("/{id}")
    public InstitutionDTO update(@RequestBody InstitutionDTO institutionDTO, @PathVariable Long id) {
        return InstitutionMapper
                .INSTANCE
                .toDTO(institutionService.update(InstitutionMapper
                        .INSTANCE
                        .fromDTO(institutionDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        institutionService.delete(id);
    }

}
