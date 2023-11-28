package MyJavaProject.DemoJava.Rest;


import MyJavaProject.DemoJava.Entity.Dto.RecommendationDto;
import MyJavaProject.DemoJava.Service.IRecommendationService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    private final IRecommendationService recommendationService;

    public RecommendationController(IRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{id}")
    public RecommendationDto findById(@PathVariable long id){
        return this.recommendationService.findById(id);
    }


    @GetMapping
    public List<RecommendationDto> findAll(){
        return this.recommendationService.findAll();
    }


    @Transactional
    @PostMapping
    public void create(@RequestBody RecommendationDto entity) {
        recommendationService.create(entity);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        recommendationService.deleteById(id);
    }

    @Transactional
    @PutMapping("/{id}")
    public void updateRecommendation(@PathVariable long id, @RequestBody RecommendationDto entity) {
        recommendationService.updateRecommendation(id, entity);
    }

//    @PatchMapping("/{id}")
//    public void softUpdateRecommendation(@PathVariable long id, @RequestBody RecommendationDto entity) {
//        RecommendationDto dto = recommendationService.findById(id);
//        if(entity.getId() != 0)
//            dto.setId(entity.getId());
//        if(entity.getCandidate() != null)
//            dto.setCandidate(entity.getCandidate());
//        if(entity.getPersonCompany() != null)
//            dto.setPersonCompany(entity.getPersonCompany());
//        if(entity.getPersonName() != null)
//            dto.setPersonName(entity.getPersonName());
//        if(entity.getPersonSurname() != null)
//            dto.setPersonSurname(entity.getPersonSurname());
//        if(entity.getRecommendationText() != null)
//            dto.setRecommendationText(entity.getRecommendationText());
//        recommendationService.updateRecommendation(id, dto);
//    }
}
