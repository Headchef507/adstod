package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
The class that each question and there multiple answers.
 */

@Entity
/*
* @Table(name = "postitnote") // If you want to specify a table name, you can do so here
* Í PostitNote þá var valmöguleikinn að setja þetta upp sem töflu
 */
public class Question {

    // Declares that this attribute is the id (primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;
    private String[] answerOptions;
    private String answer;

    //PostitNote used an empty constructor, because we need to be able to create an empty PostitNote to add
    //to our model so we can use it with our form
    public Question() {

    }
    public Question(String question, String[] answerOptions, String answer){
        this.question = question;
        this.answerOptions = answerOptions;
        this.answer = answer;

    }
    //PostitNote þá var id Long heldur en int, athuga það!!
    public int getId() { return id; }
    /*
    Vantar fleiri getters og setters
     */
}
