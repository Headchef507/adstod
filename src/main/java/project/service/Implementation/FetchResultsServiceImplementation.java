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

    // Dependency Injection
    @Autowired
    public FetchResultsServiceImplementation(QuestionRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Result> getResults(List<Question> answers) { return this.repository.getResults(answers); }


}
