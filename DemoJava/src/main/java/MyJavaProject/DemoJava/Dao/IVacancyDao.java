package MyJavaProject.DemoJava.Dao;

import MyJavaProject.DemoJava.Entity.Vacancy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVacancyDao extends CrudRepository<Vacancy, Long> {
    Vacancy findById(long id);

    List<Vacancy> findAll();

    <S extends Vacancy> S save(S entity);

    void deleteById(long id);
}
