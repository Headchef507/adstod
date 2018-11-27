package project.controller;

// Imports needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.AssistanceResource;
import project.persistence.entities.Question;
import project.persistence.entities.Result;
import project.service.FetchResultsService;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ResultsController {

    // Instance Variables
    private FetchResultsService fetchResultsService;
    private List<AssistanceResource> assistanceResources;

    // Dependency Injection
    @Autowired
    public ResultsController(FetchResultsService fetchResultsService) {
        this.fetchResultsService = fetchResultsService;
    }


    @RequestMapping (value = "/Results", method = RequestMethod.GET)
    public String getResults(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        this.assistanceResources = fetchResultsService.getResults();

        model.addAttribute("Resources", assistanceResources);

        return "/Result";
    }

    //@RequestMapping (value = "/result", method = RequestMethod.GET) //Throws error
    public List<Result> getOtherPossibleResults(List<Question> answers) {
        return null;
    }


}
