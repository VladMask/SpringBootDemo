package MyJavaProject.DemoJava.Service;


import MyJavaProject.DemoJava.Dao.IRecommendationDao;
import MyJavaProject.DemoJava.Entity.Dto.Converter.RecommendationConverter;
import MyJavaProject.DemoJava.Entity.Dto.RecommendationDto;

import java.util.List;

public class RecommendationService implements IRecommendationService{
    public RecommendationService(IRecommendationDao RecommendationDao){
        this.RecommendationDao = RecommendationDao;
    }

    private final IRecommendationDao RecommendationDao;

    public RecommendationDto findById(long id) {
        return RecommendationConverter.convertRecommendation(this.RecommendationDao.findById(id));
    }

    public List<RecommendationDto> findAll() {
        return RecommendationConverter.convertRecommendations(this.RecommendationDao.findAll());
    }

    public void create(RecommendationDto entity) {
        RecommendationDao.save(RecommendationConverter.convertDto(entity));
    }

    public void deleteById(long id) {
        RecommendationDao.deleteById(id);
    }

    public void updateRecommendation(long id, RecommendationDto entity) {
        RecommendationDao.save(RecommendationConverter.convertDto(entity));
    }
}