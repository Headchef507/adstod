package project.controller;

// Imports needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.util.List;

@Controller
public class SessionController {

    // Initializing variables
    private ProcessQuestionsService processQuestionsService;

    // Constructor
    @Autowired
    public SessionController(ProcessQuestionsService processQuestionsService) { this.processQuestionsService = processQuestionsService; }

    // Function getQuestionsFromID intended to fetch batch of questions
    // based on the int array input
    // Incomplete, likely going to change from array to single int due to
    // database change
    @RequestMapping
    public List<Question> getQuestionsFromID(int[] id) {
        return null;
    }

}
