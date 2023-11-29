package MyJavaProject.DemoJava.Rest;


import MyJavaProject.DemoJava.Entity.Dto.RecommendationDto;
import MyJavaProject.DemoJava.Service.IRecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Recommendation", description = "The Recommendation API")
@RequestMapping("/recommendations")
public class RecommendationController {
    private final IRecommendationService recommendationService;

    public RecommendationController(IRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @Operation(summary = "Finds Recommendation by id")
    @GetMapping("/{id}")
    public RecommendationDto findById(@PathVariable long id){
        return this.recommendationService.findById(id);
    }

    @Operation(summary = "Finds all Recommendations")
    @GetMapping
    public List<RecommendationDto> findAll(){
        return this.recommendationService.findAll();
    }


    @Transactional
    @Operation(summary = "Crates Recommendation")
    @PostMapping
    public void create(@RequestBody RecommendationDto entity) {
        recommendationService.create(entity);
    }

    @Transactional
    @Operation(summary = "Deletes Recommendation")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        recommendationService.deleteById(id);
    }

    @Transactional
    @Operation(summary = "Updates Recommendation by id")
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
