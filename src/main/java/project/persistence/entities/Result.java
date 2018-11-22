package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "results") // If you want to specify a table name, you can do so here
public class Result {

    //Initializing variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private AssistanceResource[] assistanceResource;

    // Empty constructor, if necessary to get an empty result object
    public Result (){

    }

    // Constructor
    public Result(String title, AssistanceResource[] assistanceResource){
        this.assistanceResource = assistanceResource;
        this.title = title;
    }

    // Getters and setters
    // ID of result in database
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    // Title of result in database
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    // Array of assistanceResources from the Result
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
