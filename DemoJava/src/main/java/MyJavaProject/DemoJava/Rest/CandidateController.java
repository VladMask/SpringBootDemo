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
}
