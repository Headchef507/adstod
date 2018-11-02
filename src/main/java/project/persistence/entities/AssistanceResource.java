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

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    public String[] getPhNumbers() { return phNumbers; }

    public void setPhNumbers(String[] phNumbers) { this.phNumbers = phNumbers; }

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
