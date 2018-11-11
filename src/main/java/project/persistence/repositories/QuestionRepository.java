package project.persistence.repositories;

// Imports needed
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import project.persistence.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/query/QueryByExampleExecutor.html?is-external=true#findOne-org.springframework.data.domain.Example-

    /**
     * List of all questions that the user has answered
     * and the latest fetched question that the user is answering at the time
     */
    List<Question> answers = null;

    /**
     * Function saveAnswers was/is intended to save an answer that the user
     * makes into the answers List above
     * Incomplete
     */
    //void saveAnswers(List<Question> answers);

    /**
     * Function getResults was/is intended to take the answers at the end
     * and match them in the database to get a result/s for the user
     */
    //List<Result> getResults(List<Question> answers);

    /**
     * Basic query made to inject into function findOne
     * Incomplete, query needs to be reworked
     * Made now to get the program running
     */
    @Query(value = "SELECT q FROM Question q WHERE q.id = ?1")
    Question findOne(Long i);

    /**
     * Function processAnswers was/is intended to get the answers
     * to the right format needed for the database
     * Incomplete, potentially useless
     */
    //void processAnswers(List<Question> answers);

}
