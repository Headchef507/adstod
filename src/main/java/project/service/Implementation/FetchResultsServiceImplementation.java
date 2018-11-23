package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Question;
import project.persistence.entities.Result;
import project.persistence.repositories.QuestionRepository;
import project.service.FetchResultsService;

import java.util.List;

@Service
public class FetchResultsServiceImplementation implements FetchResultsService {

    // Instance Variables
    private QuestionRepository repository;

    /*
    //This is the constructor
    // Dependency Injection
    // @Autowired
    public FetchResultsServiceImplementation(QuestionRepository repository) {
        this.repository = repository;
    }*/

/*
    This is where we get the object called Result, see the Entity Result for more information.
    @Override
    public List<Result> getResults(List<Question> answers) { return this.repository.getResults(answers); }
*/


}
