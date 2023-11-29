package MyJavaProject.DemoJava.Service;

import MyJavaProject.DemoJava.Dto.VacancyDto;

import java.util.List;

public interface IVacancyService {
    VacancyDto findById(long id);

    List<VacancyDto> findAll();

    void create(VacancyDto entity);

    void deleteById(long id);

    void updateVacancy(long id, VacancyDto entity);
}
