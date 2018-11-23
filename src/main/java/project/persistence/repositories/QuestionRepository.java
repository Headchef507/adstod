package project.persistence.repositories;

// Imports needed
import java.util.List;
import project.persistence.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class QuestionRepository {

//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/query/QueryByExampleExecutor.html?is-external=true#findOne-org.springframework.data.domain.Example-

    /**
     * List of all questions that the user has answered
     * and the latest fetched question that the user is answering at the time
     */
    List<Question> answers = null;
    EntityManagerFactory emf;

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
    //@Query(value = "SELECT * FROM QuestionsICE q WHERE q.id = ?1", nativeQuery = true)
    public Question findOne(Long i){
        EntityManager em = emf.createEntityManager();
        Query que = em.createNativeQuery("SELECT * FROM QuestionsICE q JOIN optionsforanswersice o on q.ID = o.QuestionID JOIN optionsice o2 on o.OptionID = o2.ID WHERE q.id = 1;");
        
        Question q = new Question();
        return q;
    }

    /**
     * Function processAnswers was/is intended to get the answers
     * to the right format needed for the database
     * Incomplete, potentially useless
     */
    //void processAnswers(List<Question> answers);

}
