package MyJavaProject.DemoJava.Service.Impl;

import MyJavaProject.DemoJava.Dao.ICandidateDao;
import MyJavaProject.DemoJava.Dao.IRecommendationDao;
import MyJavaProject.DemoJava.Dto.CandidateDto;
import MyJavaProject.DemoJava.Dto.Converter.CandidateConverter;
import MyJavaProject.DemoJava.Service.ICandidateService;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter

public class CandidateService implements ICandidateService {

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

    @Transactional
    public void create(CandidateDto entity) {
        candidateDao.save(CandidateConverter.convertDto(entity));
    }

    public void deleteById(long id) {
        candidateDao.deleteById(id);
    }

    public void updateCandidate(long id, CandidateDto entity) {

        candidateDao.save(CandidateConverter.convertDto(entity));
    }
}
