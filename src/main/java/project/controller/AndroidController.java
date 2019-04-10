package project.controller;

import org.json.JSONException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;

import org.json.JSONObject;

@RestController
public class AndroidController {
    private ProcessQuestionsService processQuestionsService;
    private HttpServletRequest request;
    private JSONObject JSONallQ;

    @RequestMapping(value = "/allquestions")
    public JSONObject getQuestions(Model model, HttpServletRequest request) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException, JSONException {
        // Set selected language
        

        String language = request.getParameter(("lang"));
        request.getSession().setAttribute("Language", language);
        this.processQuestionsService.setLanguage(language);
        List<Question> allQ = processQuestionsService.getAllQuestions();
        JSONallQ = JSONQuestion(allQ);
        return JSONallQ;
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /*report an error*/ }

        try {
            JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
        } catch (JSONException e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }

        // Work with the data using methods like...
        // int someInt = jsonObject.getInt("intParamName");
        // String someString = jsonObject.getString("stringParamName");
        // JSONObject nestedObj = jsonObject.getJSONObject("nestedObjName");
        // JSONArray arr = jsonObject.getJSONArray("arrayParamName");
        // etc...
    }



    public JSONObject JSONQuestion(List<Question> qs) throws JSONException {
        JSONObject appQuestions = new JSONObject();
        appQuestions.put("forApp", qs);
        return appQuestions;
    }

}
