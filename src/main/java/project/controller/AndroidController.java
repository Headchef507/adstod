package project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
public class AndroidController {
    private ProcessQuestionsService processQuestionsService;

    @RequestMapping(value = "/allquestions")
    public List<Question> getQuestions(Model model, HttpServletRequest request) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        // Set selected language
        String language = request.getParameter(("lang"));
        request.getSession().setAttribute("Language", language);
        this.processQuestionsService.setLanguage(language);
        List<Question> allQ = processQuestionsService.getAllQuestions();
        return allQ;
        // Put together the list of all questions

        // Following is code from SessionController, for reference while coding
        /*// Set the selected language
        String language = request.getParameter("lang");
        request.getSession().setAttribute("Language", language);
        this.processQuestionsService.setLanguage(language);

        // Add the total number of questions to the view
        this.numberOfQuestions = this.processQuestionsService.getAnswersSize();
        request.getSession().setAttribute("QuestionCount", this.numberOfQuestions);

        // Retrieve the initial question and add it to the view
        this.currentQuestion = this.processQuestionsService.findInitialQuestion();
        model.addAttribute("Question", this.currentQuestion);

        // Return the view
        return "/Question";*/
    }
}
