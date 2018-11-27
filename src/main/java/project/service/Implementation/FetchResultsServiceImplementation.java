package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import project.persistence.entities.AssistanceResource;
import project.persistence.entities.Question;
import project.persistence.entities.Result;
import project.persistence.repositories.QuestionRepository;
import project.service.FetchResultsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchResultsServiceImplementation implements FetchResultsService {

    // Instance Variables
    private QuestionRepository repository = QuestionRepository.getInstance();              //to contact the repository
    private List<Question> answeredQuestion;            //placeholder for the Questions List to work with them
    private List<AssistanceResource> assistanceResources = new ArrayList<>(); //List of all of the


    //This is the constructor
    // Dependency Injection
   /*  @Autowired
    public FetchResultsServiceImplementation() {
    } */
    public List<Question> getAnsweredQuestion() { //doesn´t do anything;
        return answeredQuestion;
    }



    ////This is where we get the object called Result, see the Entity Result for more information.
    //This is where we receive the AssistanceResources and add theme to the list
    //the first one is the one that fits the most
    @Override
    public List<AssistanceResource> getResults() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.answeredQuestion = repository.getAnswers();
        long id = 2;
        AssistanceResource a = repository.getResult(id); //test entity for debugging
        if (answeredQuestion.get(0).getAnswer() == 1 &&
                answeredQuestion.get(5).getAnswer() == 1)
            assistanceResources.add(repository.getResult((long)1));
            //assistanceResources = repository.getResults();
            //this is how we want to work, it doesn´t cry, because to fix repository

        /*if(true)
            assistanceResources.add(a);*/
        assistanceResources.add(repository.getResult((long)2));
        assistanceResources.add(repository.getResult((long)3));
        assistanceResources.add(repository.getResult((long)4));
        assistanceResources.add(repository.getResult((long)5));
        assistanceResources.add(repository.getResult((long)6)); //default Assistance Resource



        return assistanceResources; //here comes the default AssistanceResource
    }


}
