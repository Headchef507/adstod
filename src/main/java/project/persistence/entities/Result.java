package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "postitnote") // If you want to specify a table name, you can do so here
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private AssistanceResource[] assistanceResource;

    public Result (){

    }

    public Result(String title, AssistanceResource[] assistanceResource){
        this.assistanceResource = assistanceResource;
        this.title = title;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public AssistanceResource[] getAssistanceResource() { return assistanceResource; }

    public void setAssistanceResource(AssistanceResource[] assistanceResource) { this.assistanceResource = assistanceResource; }

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
