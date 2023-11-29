package MyJavaProject.DemoJava.Rest;

import MyJavaProject.DemoJava.Dto.CandidateDto;
import MyJavaProject.DemoJava.Service.ICandidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Candidate", description = "The Candidate API")
@RequestMapping("/candidates")

public class CandidateController {
    private final ICandidateService candidateService;

    public CandidateController(ICandidateService candidateService){
        this.candidateService = candidateService;
    }


    @Operation(summary = "Finds Candidate by id")
    @GetMapping("/{id}")
    public CandidateDto findById(@PathVariable long id){
        return this.candidateService.findById(id);
    }


    @Operation(summary = "Finds all Candidates")
    @GetMapping
    public List<CandidateDto> findAll(){
        return this.candidateService.findAll();
    }

    @Operation(summary = "Creates Candidate")
    @PostMapping
    public void create(@RequestBody CandidateDto entity) {
        candidateService.create(entity);
    }

    @Operation(summary = "Deletes Candidate by id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        candidateService.deleteById(id);
    }

    @Operation(summary = "Updates Candidate by id")
    @PutMapping("/{id}")
    public void updateCandidate(@PathVariable long id, @RequestBody CandidateDto entity) {
        candidateService.updateCandidate(id, entity);
    }

    @Operation(summary = "Updates Candidate by id")
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
