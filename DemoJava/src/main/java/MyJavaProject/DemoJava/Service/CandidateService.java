package MyJavaProject.DemoJava.Service;

import MyJavaProject.DemoJava.Dao.ICandidateDao;
import MyJavaProject.DemoJava.Entity.Dto.Converter.CandidateConverter;
import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter

public class CandidateService implements ICandidateService{

    public CandidateService(ICandidateDao candidateDao){
        this.candidateDao = candidateDao;
    }

    private final ICandidateDao candidateDao;

    public CandidateDto findById(long id) {
        return CandidateConverter.convertCandidate(this.candidateDao.findById(id));
    }

    public List<CandidateDto> findAll() {
        return CandidateConverter.ConverCandidates(this.candidateDao.findAll());
    }
}
