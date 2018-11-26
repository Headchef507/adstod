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
    private Question currentQuestion = null;
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
    public String getInitialQuestion(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        numberOfQuestions = processQuestionsService.getAnswersSize();
        model.addAttribute("QuestionCount", numberOfQuestions);

        currentQuestion = processQuestionsService.findInitialQuestion();
        model.addAttribute("Question", currentQuestion);

        // Return the view
        return "/Question";
    }

    @RequestMapping (value = "/NextQuestion", method = RequestMethod.GET)
    public String getNextQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        currentQuestion = processQuestionsService.findNextQuestion(currentQuestion.getId());
        model.addAttribute("Question", currentQuestion);
        model.addAttribute("QuestionCount", numberOfQuestions);

        return "/Question";
    }

    @RequestMapping (value = "/PrevQuestion", method = RequestMethod.GET)
    public String getPreviousQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        currentQuestion = processQuestionsService.findPreviousQuestion(currentQuestion.getId());
        model.addAttribute("Question", currentQuestion);
        model.addAttribute("QuestionCount", numberOfQuestions);

        return "/Question";
    }


    @RequestMapping (value = "/Results", method = RequestMethod.GET)
    public String getResults(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {


        return "/Results";
    }


}
