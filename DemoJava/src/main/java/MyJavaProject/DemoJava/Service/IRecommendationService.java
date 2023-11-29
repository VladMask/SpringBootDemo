package MyJavaProject.DemoJava.Service;


import MyJavaProject.DemoJava.Dto.RecommendationDto;

import java.util.List;

public interface IRecommendationService {
    RecommendationDto findById(long id);

    List<RecommendationDto> findAll();

    void create(RecommendationDto entity);

    void deleteById(long id);

    void updateRecommendation(long id, RecommendationDto entity);
}
