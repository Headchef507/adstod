package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.AssistanceResource;
import project.persistence.entities.Question;
import project.persistence.entities.Result;
import project.persistence.repositories.QuestionRepository;
import project.service.FetchResultsService;

import java.util.List;

@Service
public class FetchResultsServiceImplementation implements FetchResultsService {

    // Instance Variables
    private QuestionRepository repository;              //to contact the repository
    private List<Question> answeredQuestion;            //placeholder for the Questions List to work with them
    private List<AssistanceResource> assistanceResources; //List of all of the


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
    public List<Result> getResults() {
        this.answeredQuestion = repository.getAnswers();

        AssistanceResource a = new AssistanceResource();
        if (answeredQuestion.get(0).getAnswer() == 1 ||
                answeredQuestion.get(5).getAnswer() == 1)
            //assistanceResources.add(repository.getResults());
            //this is how we want to work, it doesn´t cry, because to fix repository
            assistanceResources.add(a);



        return this.repository.getResults(); //here comes the default AssistanceResource
    }


}
