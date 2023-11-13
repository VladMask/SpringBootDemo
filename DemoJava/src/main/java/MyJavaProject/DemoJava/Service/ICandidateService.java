package MyJavaProject.DemoJava.Service;

import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;

import java.util.List;

public interface ICandidateService {
    CandidateDto findById(long id);

    List<CandidateDto> findAll();
}
