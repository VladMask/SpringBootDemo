package MyJavaProject.DemoJava.Service.Impl;


import MyJavaProject.DemoJava.Dao.IRecommendationDao;
import MyJavaProject.DemoJava.Dto.Converter.RecommendationConverter;
import MyJavaProject.DemoJava.Dto.RecommendationDto;
import MyJavaProject.DemoJava.Service.IRecommendationService;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class RecommendationService implements IRecommendationService {
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

    @Transactional
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
