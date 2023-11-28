package MyJavaProject.DemoJava.Rest;

import MyJavaProject.DemoJava.Entity.Dto.VacancyDto;
import MyJavaProject.DemoJava.Service.IVacancyService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    private final IVacancyService vacancyService;

    public VacancyController(IVacancyService vacancyService){
        this.vacancyService = vacancyService;
    }

    @GetMapping("/{id}")
    public VacancyDto findById(@PathVariable long id){
        return this.vacancyService.findById(id);
    }

    @GetMapping
    public List<VacancyDto> findAll(){
        return this.vacancyService.findAll();
    }

    @Transactional
    @PostMapping
    public void create(@RequestBody VacancyDto entity) {
        vacancyService.create(entity);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        vacancyService.deleteById(id);
    }

    @Transactional
    @PutMapping("/{id}")
    public void updateVacancy(@PathVariable long id, @RequestBody VacancyDto entity) {
        vacancyService.updateVacancy(id, entity);
    }

    @Transactional
    @PatchMapping("/{id}")
    public void softUpdateVacancy(@PathVariable long id, @RequestBody VacancyDto entity) {
        VacancyDto dto = vacancyService.findById(id);
        if(entity.getId() != 0)
            dto.setId(entity.getId());
        if(entity.getCompanyName() != null)
            dto.setCompanyName(entity.getCompanyName());
        if(entity.getDescription() != null)
            dto.setDescription(entity.getDescription());
        vacancyService.updateVacancy(id, dto);
    }
}

