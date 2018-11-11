package project.controller;

// Imports needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.util.List;

@Controller
public class StatusController {

    // Initializing variables
    private ProcessQuestionsService processQuestionsService;

    // Constructor
    @Autowired
    public StatusController(ProcessQuestionsService processQuestionsService) { this.processQuestionsService = processQuestionsService; }

    // Function getStatusBasedOnAnswers intended to return status of where user is in
    // questioning process
    // Incomplete
    //@RequestMapping //Throws error
    public int getStatusBasedOnAnswers(List<Question> answers) {
        return 0;
    }
}
