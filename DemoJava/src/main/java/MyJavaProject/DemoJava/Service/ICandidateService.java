package MyJavaProject.DemoJava.Service;

import MyJavaProject.DemoJava.Dto.CandidateDto;

import java.util.List;

public interface ICandidateService {
    CandidateDto findById(long id);

    List<CandidateDto> findAll();

    void create(CandidateDto entity);

//    void delete(CandidateDto entity);

    void deleteById(long id);

    void updateCandidate(long id, CandidateDto entity);
}
