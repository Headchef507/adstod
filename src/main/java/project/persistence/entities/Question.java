package project.persistence.entities;

import javax.persistence.*;
import java.util.Iterator;
/*
The class that each question and there multiple answers.
 */

@Entity
/*
* @Table(name = "postitnote") // If you want to specify a table name, you can do so here
* Í PostitNote þá var valmöguleikinn að setja þetta upp sem töflu
 */
@Table(name = "questionsice")
@SecondaryTables({
        @SecondaryTable(name="questionseng"),
        @SecondaryTable(name="questionspol")
})
public class Question implements Iterator<Question> {

    // Declares that this attribute is the id (primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;
    private String[] answerOptions;
    private String answer;
    private String language;

    //PostitNote used an empty constructor, because we need to be able to create an empty PostitNote to add
    //to our model so we can use it with our form
    public Question() {
        //We need and empty Question in the beginning
    }
    public Question(String question, String[] answerOptions, String answer){
        this.question = question;
        this.answerOptions = answerOptions;
        this.answer = answer;

    }
    //PostitNote þá var id Long heldur en int, athuga það!!


    //the id of each question
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }


    //this is where the answer the User picks best fits him or her.
    public String getAnswer(){ return answer; }

    public void setAnswer(String answer){ this.answer = answer; }

    //the question for the User. For example: question == "What is your sex?"
    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }


   //These are the users answer options
    //Some range from: "I strongly agree" to "I strongly disagree"
    //others are simple yes and no questions.
    public String[] getAnswerOptions() { return answerOptions; }

    public void setAnswerOptions(String[] answerOptions) { this.answerOptions = answerOptions; }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    //The following hasNext og Next eru til að ítra yfir allar spurningarnar
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Question next() {
        return null;
    }

    //This is for easier debug in PostitNote
    /*
    @Override
    public String toString(){
        return String.format(
               "Postit Note[name=%s, note=%s]",
                name,note);
    }
    */
}
