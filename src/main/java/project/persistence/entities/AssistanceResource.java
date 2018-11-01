package project.persistence.entities;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "postitnote") // If you want to specify a table name, you can do so here
public class AssistanceResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String link;
    private String[] phNumbers;

    public AssistanceResource(){

    }
    public AssistanceResource(String title, String link, String[] phNumbers){
        this.title = title;
        this.link = link;
        this.phNumbers = phNumbers;
    }

    /*
    Vantar hér getters og setters!!
     */

}
