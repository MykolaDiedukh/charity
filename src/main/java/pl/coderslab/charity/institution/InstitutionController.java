package pl.coderslab.charity.institution;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.institution.domain.Institution;

import java.util.List;

@Controller
@RequestMapping("/institution")
@RequiredArgsConstructor
class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping
    public List<Institution> findAll(){
        return institutionService.findAll();
    }

    @GetMapping("/{id}")
    public Institution findById(@PathVariable Long id){
        return institutionService.findById(id);
    }

    @PostMapping
    public Long create(@RequestBody Institution institution){
        return institutionService.create(institution);
    }

    @PutMapping("/{id}")
    public Institution update(@RequestBody Institution institution, @PathVariable Long id){
        return institutionService.update(institution, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        institutionService.delete(id);
    }


}
