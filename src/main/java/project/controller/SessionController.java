package project.controller;

// Imports needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.sql.SQLException;

@Controller
public class SessionController {

    // Initializing variables
    private ProcessQuestionsService processQuestionsService;
    private int currentQuestion = 0;
    private int numberOfQuestions = 2;

    // Constructor
    @Autowired
    public SessionController(ProcessQuestionsService processQuestionsService) { this.processQuestionsService = processQuestionsService; }

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home(){

        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
          return "Index";
    }

    @RequestMapping (value = "/Question", method = RequestMethod.GET)
    public String getQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        if (currentQuestion == 0) {
            numberOfQuestions = processQuestionsService.getAnswersSize();
            currentQuestion++;
        }
        model.addAttribute("QuestionCount", numberOfQuestions);

        Question q = processQuestionsService.findOne(currentQuestion);
        model.addAttribute("Question", q);

        // Return the view
        return "/Question";
    }

    @RequestMapping (value = "/NextQuestion", method = RequestMethod.GET)
    public String getNextQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        currentQuestion++;
        return getQuestionFromID(model);
    }

    @RequestMapping (value = "/PrevQuestion", method = RequestMethod.GET)
    public String getPreviousQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        if (currentQuestion != 1) {
            currentQuestion--;
        }
        return getQuestionFromID(model);
    }


    @RequestMapping (value = "/Results", method = RequestMethod.GET)
    public String getResults(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {


        return "/Results";
    }


}
