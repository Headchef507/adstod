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
import java.util.List;

@Controller
public class SessionController {

    // Initializing variables
    private ProcessQuestionsService processQuestionsService;
    private int currentQuestion = 0;
    Question q;

    // Constructor
    @Autowired
    public SessionController(ProcessQuestionsService processQuestionsService) { this.processQuestionsService = processQuestionsService; }

    // Function getQuestionsFromID intended to fetch batch of questions
    // based on the int array input
    // Incomplete, likely going to change from array to single int due to
    // database change
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home(){

        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
          return "Index"; //getum núna notað fallið
    }

    @RequestMapping (value = "/Question", method = RequestMethod.GET)
    public String getQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        if (currentQuestion == 0) {
            model.addAttribute("QuestionCount", processQuestionsService.getAnswersSize());
            currentQuestion++;
        }
        q = processQuestionsService.findOne(currentQuestion);
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
    public String getFinalQuestionFromID(Model model) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {


        return "/Results";
    }


}
