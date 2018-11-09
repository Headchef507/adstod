package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Question;
import project.persistence.entities.Result;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> answers = null;

    void saveAnswers(List<Question> answers);

    List<Result> getResults(List<Question> answers);

    List<Question> getQuestionsById(int[] id);

    void processAnswers(List<Question> answers);

}
