package project.persistence.repositories;

// Imports needed
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import project.persistence.entities.AssistanceResource;
import project.persistence.entities.Question;
import project.persistence.entities.Result;

import java.sql.*;

import javax.persistence.*;

@Repository
public class QuestionRepository {
    private static QuestionRepository repository = null;

    /**
     * List of all questions that the user has answered
     * and the latest fetched question that the user is answering at the time
     */
    private boolean initList = true;
    private List<Question> answers = null;
    private Question q;
    private List<AssistanceResource> results = null;
    private Connection conn = null;
    private String username = "kannski";
    private String password = "Kannski123";
    private String url = "jdbc:mysql://localhost:3306/adstodQuestions";
    private String language = "ICE";

    public QuestionRepository() {
        //a loop to set the lists size at 16 (which is the current amount
        //of Questions.
        String [] a = new String[1];
        this.q = new Question(0, "", a, 0);
        this.answers = new ArrayList<Question>();
        this.results = new ArrayList<AssistanceResource>();
        //for(int i = 0; i < 16; i++) this.answers.add(b);
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

    public static QuestionRepository getInstance(){
        if(repository == null)
            repository = new QuestionRepository();
        return repository;
    }

    /**
     * Function saveAnswers was/is intended to save an answer that the user
     * makes into the answers List above
     * Incomplete
     */
    public void saveAnswers(int theId, Question answer){
        this.answers.set(theId, answer);

    }

    /**
     * Function getResults was/is intended to take the answers at the end
     * and match them in the database to get a result/s for the user
     */
    //What Results we want depends on the FetchResultsService
    public AssistanceResource getResult(Long id) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, username, password);
        String stmt2 = "SELECT a.ID, a.Title, a.Link, p.Number, a.Description, a.PhoneNumberCount FROM AssistanceResourcesICE a JOIN PhoneNumbersForResourcesICE p2 ON a.ID = p2.AssistanceResourceID JOIN PhoneNumbers p ON p.ID = p2.PhoneNumberID WHERE a.ID = " + id.toString();
        if(language.equals("ICE"))
            stmt2 = "SELECT a.ID, a.Title, a.Link, p.Number, a.Description, a.PhoneNumberCount FROM AssistanceResourcesICE a JOIN PhoneNumbersForResourcesICE p2 ON a.ID = p2.AssistanceResourceID JOIN PhoneNumbers p ON p.ID = p2.PhoneNumberID WHERE a.ID = " + id.toString();
        else if(language.equals("ENG"))
            stmt2 = "SELECT a.ID, a.Title, a.Link, p.Number, a.Description, a.PhoneNumberCount FROM AssistanceResourcesENG a JOIN PhoneNumbersForResourcesENG p2 ON a.ID = p2.AssistanceResourceID JOIN PhoneNumbers p ON p.ID = p2.PhoneNumberID WHERE a.ID = " + id.toString();
        else if(language.equals("POL"))
            stmt2 = "SELECT a.ID, a.Title, a.Link, p.Number, a.Description, a.PhoneNumberCount FROM AssistanceResourcesPOL a JOIN PhoneNumbersForResourcesPOL p2 ON a.ID = p2.AssistanceResourceID JOIN PhoneNumbers p ON p.ID = p2.PhoneNumberID WHERE a.ID = " + id.toString();
        Statement prep = conn.createStatement();
        ResultSet r = prep.executeQuery(stmt2);
        int x = 0;
        AssistanceResource a = new AssistanceResource();
        if(r.next()) {
            x = r.getInt(6);
        }
        String[] nums = new String[x];
        nums[0] = r.getString(4);
        a.setId(r.getLong(1));
        a.setTitle(r.getString(2));
        a.setLink(r.getString(3));
        a.setDescription(r.getString(5));
        int j = 1;
        while(r.next()){
            nums[j] = r.getString(4);
            j++;
        }
        a.setPhNumbers(nums);
        conn.close();
        return a;
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
    public Question findQuestion(Long id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Initialize list to get up the empty list to work with
        if(initList){
            for(int j = 0; j < getAnswersSize();j++){
                this.answers.add(this.q);
            }
            this.initList = false;
        }

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, username, password);
        String stmt = "SELECT q.id, q.QuestionText, q.OptionCount, o2.OptionText FROM QuestionsICE q JOIN OptionsForAnswersICE o on q.ID = o.QuestionID JOIN OptionsICE o2 on o.OptionID = o2.ID WHERE q.id = " + id.toString();
        if(language.equals("ICE"))
            stmt = "SELECT q.id, q.QuestionText, q.OptionCount, o2.OptionText FROM QuestionsICE q JOIN OptionsForAnswersICE o on q.ID = o.QuestionID JOIN OptionsICE o2 on o.OptionID = o2.ID WHERE q.id = " + id.toString();
        else if(language.equals("ENG"))
            stmt = "SELECT q.id, q.QuestionText, q.OptionCount, o2.OptionText FROM QuestionsENG q JOIN OptionsForAnswersENG o on q.ID = o.QuestionID JOIN OptionsENG o2 on o.OptionID = o2.ID WHERE q.id = " + id.toString();
        else if(language.equals("POL"))
            stmt = "SELECT q.id, q.QuestionText, q.OptionCount, o2.OptionText FROM QuestionsPOL q JOIN OptionsForAnswersPOL o on q.ID = o.QuestionID JOIN OptionsPOL o2 on o.OptionID = o2.ID WHERE q.id = " + id.toString();
        Statement prep = conn.createStatement();
        ResultSet r = prep.executeQuery(stmt);
        int x = 0;
        if(r.next()) {
            x = r.getInt(3);
        }
        String[] options = new String[x];
        options[0] = r.getString(4);
        Question q = new Question();
        int j = 1;
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

    public int getAnswersSize() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, username, password);
        String stmt = "SELECT id FROM QuestionsICE ORDER BY ID DESC LIMIT 1;";
        if(language.equals("ICE"))
            stmt = "SELECT id FROM QuestionsICE ORDER BY ID DESC LIMIT 1;";
        else if(language.equals("ENG"))
            stmt = "SELECT id FROM QuestionsENG ORDER BY ID DESC LIMIT 1;";
        else if(language.equals("POL"))
            stmt = "SELECT id FROM QuestionsPOL ORDER BY ID DESC LIMIT 1;";
        Statement prep = conn.createStatement();
        ResultSet r = prep.executeQuery(stmt);
        int c = 0;
        if(r.next())
            c = r.getInt(1);
        return c;
    }

    public String getLanguage(){ return this.language; }

    public void setLanguage(String language){ this.language = language; }

    /**
     * Function processAnswers was/is intended to get the answers
     * to the right format needed for the database
     * Incomplete, potentially useless
     */
    //void processAnswers(List<Question> answers);

}
