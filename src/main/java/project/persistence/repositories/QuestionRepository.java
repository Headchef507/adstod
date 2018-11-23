package project.persistence.repositories;

// Imports needed
import java.util.ArrayList;
import java.util.List;
import project.persistence.entities.Question;
import java.sql.*;

import javax.persistence.*;

public class QuestionRepository {

    /**
     * List of all questions that the user has answered
     * and the latest fetched question that the user is answering at the time
     */
    List<Question> answers = null;
    private Connection conn = null;
    private String url = "jdbc::mysql://localhost:3306/adstodQuestions";

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
    //void saveAnswers(List<Question> answers);

    /**
     * Function getResults was/is intended to take the answers at the end
     * and match them in the database to get a result/s for the user
     */
    //List<Result> getResults(List<Question> answers);

    /**
     * Basic query made to inject into function findOne
     * Incomplete, query needs to be reworked
     * Made now to get the program running
     */
    //@Query(value = "SELECT * FROM QuestionsICE q WHERE q.id = ?1", nativeQuery = true)
    public Question findOne(Long i) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url);
        System.out.println("Got here");
        String stmt = "SELECT q.id, q.QuestionText, q.OptionCount, o2.OptionText FROM QuestionsICE q JOIN optionsforanswersice o on q.ID = o.QuestionID JOIN optionsice o2 on o.OptionID = o2.ID WHERE q.id = " + i.toString();
        System.out.println("Created Statement");
        Statement prep = conn.createStatement();
        System.out.println("Prepped statement");
        ResultSet r = prep.executeQuery(stmt);
        System.out.println("Got result set");
        String[] options = new String[r.getInt(2)];
        Question q = new Question();
        q.setId(r.getLong(0));
        q.setQuestionText(r.getString(1));
        int j = 0;
        while(r.next()){
            options[j] = r.getString(3);
            j++;
        }
        q.setAnswerOptions(options);
        conn.close();*/
        String[] options = {"yes", "no"};
        Question q = new Question(1, "test question not from db", options, null);
        return q;
    }

    /**
     * Function processAnswers was/is intended to get the answers
     * to the right format needed for the database
     * Incomplete, potentially useless
     */
    //void processAnswers(List<Question> answers);

}
