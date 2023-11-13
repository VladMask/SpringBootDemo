package MyJavaProject.DemoJava.Rest;

import MyJavaProject.DemoJava.Entity.Dto.VacancyDto;
import MyJavaProject.DemoJava.Service.IVacancyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/all")
    public List<VacancyDto> findAll(){
        return this.vacancyService.findAll();
    }
}

