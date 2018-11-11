package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Question;
import project.persistence.entities.Result;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/query/QueryByExampleExecutor.html?is-external=true#findOne-org.springframework.data.domain.Example-

    List<Question> answers = null;

    //void saveAnswers(List<Question> answers);

    List<Result> getResults(List<Question> answers);

    List<Question> findBy(int i);

    void processAnswers(List<Question> answers);

}
