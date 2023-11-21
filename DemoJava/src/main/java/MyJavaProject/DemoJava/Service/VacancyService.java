package MyJavaProject.DemoJava.Service;


import MyJavaProject.DemoJava.Dao.IVacancyDao;
import MyJavaProject.DemoJava.Entity.Dto.CandidateDto;
import MyJavaProject.DemoJava.Entity.Dto.Converter.CandidateConverter;
import MyJavaProject.DemoJava.Entity.Dto.VacancyDto;
import MyJavaProject.DemoJava.Entity.Dto.Converter.VacancyConverter;
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
