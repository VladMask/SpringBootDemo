package MyJavaProject.DemoJava.Service;

import MyJavaProject.DemoJava.Dao.ICandidateDao;
import MyJavaProject.DemoJava.Dao.IRecommendationDao;
import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;
import MyJavaProject.DemoJava.Entity.Dto.Converter.CandidateConverter;
import MyJavaProject.DemoJava.Entity.Recommendation;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter

public class CandidateService implements ICandidateService{

//    public CandidateService(ICandidateDao candidateDao) {
//        this.candidateDao = candidateDao;
//    }

    public CandidateService(ICandidateDao candidateDao, IRecommendationDao recommendationDao){
        this.candidateDao = candidateDao;
        this.recommendationDao = recommendationDao;
    }

    private final ICandidateDao candidateDao;
    private final IRecommendationDao recommendationDao;

    public CandidateDto findById(long id) {
        return CandidateConverter.convertCandidate(this.candidateDao.findById(id));
    }

    public List<CandidateDto> findAll() {
        return CandidateConverter.ConverCandidates(this.candidateDao.findAll());
    }

    public void create(CandidateDto entity) {
        candidateDao.save(CandidateConverter.convertDto(entity));
    }

    public void deleteById(long id) {
        List<Recommendation> recommendations = candidateDao.findById(id).getRecommendations();
        for (Recommendation r: recommendations) {
            recommendationDao.deleteById(r.getId());
        }
        candidateDao.deleteById(id);
    }

    public void updateCandidate(long id, CandidateDto entity) {

        candidateDao.save(CandidateConverter.convertDto(entity));
    }
}
