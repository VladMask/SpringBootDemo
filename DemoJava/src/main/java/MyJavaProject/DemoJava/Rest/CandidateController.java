package MyJavaProject.DemoJava.Rest;

import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;
import MyJavaProject.DemoJava.Service.ICandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/all")
    public List<CandidateDto> findAll(){
        return this.candidateService.findAll();
    }
}
