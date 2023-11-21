package MyJavaProject.DemoJava.Rest;

import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;
import MyJavaProject.DemoJava.Entity.Dto.Converter.CandidateConverter;
import MyJavaProject.DemoJava.Service.ICandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")

public class CandidateController {
    private final ICandidateService candidateService;

    public CandidateController(ICandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping("/{id}")
    public CandidateDto findById(@PathVariable long id){
        return this.candidateService.findById(id);
    }

    @GetMapping
    public List<CandidateDto> findAll(){
        return this.candidateService.findAll();
    }

    @PostMapping
    public void create(@RequestBody CandidateDto entity) {
        candidateService.create(entity);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        candidateService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCandidate(@PathVariable long id, @RequestBody CandidateDto entity) {
        candidateService.updateCandidate(id, entity);
    }

    @PatchMapping("/{id}")
    public void softUpdateCandidate(@PathVariable long id, @RequestBody CandidateDto entity) {
        CandidateDto dto = candidateService.findById(id);
        if(entity.getId() != 0)
            dto.setId(entity.getId());
        if (entity.getAge() != 0)
            dto.setAge(entity.getAge());
        if (entity.getName() != null)
            dto.setName(entity.getName());
        if (entity.getSurname() != null)
            dto.setSurname(entity.getSurname());
        if (entity.getSkillsDescription() != null)
            dto.setSkillsDescription(entity.getSkillsDescription());
        candidateService.updateCandidate(id, dto);
    }
}
