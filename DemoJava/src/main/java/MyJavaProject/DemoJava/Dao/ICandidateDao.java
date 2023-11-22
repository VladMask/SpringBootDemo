package MyJavaProject.DemoJava.Dao;

import MyJavaProject.DemoJava.Entity.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICandidateDao extends CrudRepository<Candidate, Long> {

    Candidate findById(long id);

    List<Candidate> findAll();

    <S extends Candidate> S save(S entity);

    void deleteById(long id);

}
