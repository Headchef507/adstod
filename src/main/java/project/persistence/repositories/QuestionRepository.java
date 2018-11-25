package project.persistence.repositories;

// Imports needed
import java.util.ArrayList;
import java.util.List;
import project.persistence.entities.Question;
import project.persistence.entities.Result;

import java.sql.*;

import javax.persistence.*;

public class QuestionRepository {

    /**
     * List of all questions that the user has answered
     * and the latest fetched question that the user is answering at the time
     */
    List<Question> answers = null;
    List<Result> results = null;
    private Connection conn = null;
    private String username = "kannski";
    private String password = "Kannski123";
    private String url = "jdbc:mysql://localhost:3306/adstodQuestions";

    public void QuestionRepository(){
        System.out.println("x");
        /*try{
            conn = DriverManager.getConnection(url);
            System.out.println("null");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }*/
    }

    /**
     * Function saveAnswers was/is intended to save an answer that the user
     * makes into the answers List above
     * Incomplete
     */
    public void saveAnswers(Question answer){
        this.answers.add(answer);

    }

    /**
     * Function getResults was/is intended to take the answers at the end
     * and match them in the database to get a result/s for the user
     */
    //What Reults we want depends on the FetchReultsService
    public List<Result> getResults() {
        return this.results;
    }

    //The function sends into FetchResults the list of questions with their answers
    //so it is possible to work with it
    public List<Question> getAnswers(){
        return this.answers;
    }

    /**
     * Basic query made to inject into function findOne
     * Incomplete, query needs to be reworked
     * Made now to get the program running
     */
    public Question findOne(Long i) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, username, password);
        String stmt = "SELECT q.id, q.QuestionText, q.OptionCount, o2.OptionText FROM QuestionsICE q JOIN optionsforanswersice o on q.ID = o.QuestionID JOIN optionsice o2 on o.OptionID = o2.ID WHERE q.id = " + i.toString();
        Statement prep = conn.createStatement();
        ResultSet r = prep.executeQuery(stmt);
        int x = 0;
        if(r.next())
            x = r.getInt(3);
        String[] options = new String[x];
        Question q = new Question();
        int j = 0;
        while(r.next()){
            q.setId(r.getLong(1));
            q.setQuestionText(r.getString(2));
            options[j] = r.getString(4);
            j++;
        }
        q.setAnswerOptions(options);
        conn.close();
        return q;
    }

    /**
     * Function processAnswers was/is intended to get the answers
     * to the right format needed for the database
     * Incomplete, potentially useless
     */
    //void processAnswers(List<Question> answers);

}
