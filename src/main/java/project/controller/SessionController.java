package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.util.List;

@Controller
public class SessionController {

    private ProcessQuestionsService processQuestionsService;

    @Autowired
    public SessionController(ProcessQuestionsService processQuestionsService) { this.processQuestionsService = processQuestionsService; }

    @RequestMapping
    public List<Question> getQuestionsFromID(int[] id) {
        return null;
    }

}
