package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.util.List;

@Controller
public class StatusController {

    private ProcessQuestionsService processQuestionsService;

    @Autowired
    public StatusController(ProcessQuestionsService processQuestionsService) { this.processQuestionsService = processQuestionsService; }

    @RequestMapping
    public int getStatusBasedOnAnswers(List<Question> answers) {
        return 0;
    }
}
