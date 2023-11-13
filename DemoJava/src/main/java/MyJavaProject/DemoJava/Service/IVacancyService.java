package MyJavaProject.DemoJava.Service;

import MyJavaProject.DemoJava.Entity.Dto.VacancyDto;

import java.util.List;

public interface IVacancyService {
    VacancyDto findById(long id);

    List<VacancyDto> findAll();
}
