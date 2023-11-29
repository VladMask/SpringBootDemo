package MyJavaProject.DemoJava.Service.Impl;


import MyJavaProject.DemoJava.Dao.IVacancyDao;
import MyJavaProject.DemoJava.Dto.VacancyDto;
import MyJavaProject.DemoJava.Dto.Converter.VacancyConverter;
import MyJavaProject.DemoJava.Service.IVacancyService;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class VacancyService implements IVacancyService {
    public VacancyService(IVacancyDao vacancyDao){
        this.vacancyDao = vacancyDao;
    }

    private final IVacancyDao vacancyDao;

    public VacancyDto findById(long id) {
        return VacancyConverter.convertVacancy(this.vacancyDao.findById(id));
    }

    public List<VacancyDto> findAll() {
        return VacancyConverter.convertVacancies(this.vacancyDao.findAll());
    }

    @Transactional
    public void create(VacancyDto entity) {
        vacancyDao.save(VacancyConverter.convertDto(entity));
    }

    public void deleteById(long id) {
        vacancyDao.deleteById(id);
    }

    public void updateVacancy(long id, VacancyDto entity) {
        vacancyDao.save(VacancyConverter.convertDto(entity));
    }
}
