package project.persistence.repositories;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Question;
import project.persistence.entities.Result;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/query/QueryByExampleExecutor.html?is-external=true#findOne-org.springframework.data.domain.Example-

    List<Question> answers = null;

    //void saveAnswers(List<Question> answers);

    //List<Result> getResults(List<Question> answers);

    @Query(value = "SELECT q FROM Question q WHERE q.id = ?1")
    Question findOne(Long i);

    //void processAnswers(List<Question> answers);

}
