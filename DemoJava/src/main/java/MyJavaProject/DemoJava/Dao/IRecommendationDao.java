package MyJavaProject.DemoJava.Dao;

import MyJavaProject.DemoJava.Entity.Recommendation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRecommendationDao extends CrudRepository<Recommendation, Long> {
    Recommendation findById(long id);

    List<Recommendation> findAll();

    <S extends Recommendation> S save(S entity);

    void deleteById(long id);
}
