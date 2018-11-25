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
    int x = 0;
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
        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        //model.addAttribute("question",new Question());

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        if(x == 0) {
            q = processQuestionsService.findOne(1);
            model.addAttribute("Question", q);
            x++;
        } else {
            q = processQuestionsService.findOne(processQuestionsService.findNextQuestion(q));
            model.addAttribute("Question", q);
            model.addAttribute("QuestionCount", processQuestionsService.getAnswersSize());
        }

        // Return the view
        return "/Question";
    }

}
