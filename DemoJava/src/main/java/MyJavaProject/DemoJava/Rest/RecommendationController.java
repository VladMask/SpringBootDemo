package MyJavaProject.DemoJava.Rest;


import MyJavaProject.DemoJava.Dto.RecommendationDto;
import MyJavaProject.DemoJava.Service.IRecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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


    @Operation(summary = "Crates Recommendation")
    @PostMapping
    public void create(@RequestBody RecommendationDto entity) {
        recommendationService.create(entity);
    }

    @Operation(summary = "Deletes Recommendation")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        recommendationService.deleteById(id);
    }

    @Operation(summary = "Updates Recommendation by id")
    @PutMapping("/{id}")
    public void updateRecommendation(@PathVariable long id, @RequestBody RecommendationDto entity) {
        recommendationService.updateRecommendation(id, entity);
    }

}
