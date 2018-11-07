package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Question;
import project.persistence.entities.Result;
import project.service.FetchResultsService;

import java.util.List;

@Controller
public class ResultsController {

    // Instance Variables
    private FetchResultsService fetchResultsService;

    // Dependency Injection
    @Autowired
    public ResultsController(FetchResultsService fetchResultsService) {
        this.fetchResultsService = fetchResultsService;
    }

    @RequestMapping (value = "/result", method = RequestMethod.GET)
    public void getResultsBasedOnAnswers(List<Question> answers) {

    }

    @RequestMapping (value = "/result", method = RequestMethod.GET)
    public List<Result> getOtherPossibleResults(List<Question> answers) {
        return null;
    }


}
