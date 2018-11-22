package project.persistence.entities;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "assistanceresources") // If you want to specify a table name, you can do so here
/*@SecondaryTables({
        @SecondaryTable(name="name", pkJoinColumns={
                @PrimaryKeyJoinColumn(name="id", referencedColumnName="student_id") }),
        @SecondaryTable(name="address", pkJoinColumns={
                @PrimaryKeyJoinColumn(name="id", referencedColumnName="student_id") })
})*/
public class AssistanceResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    /**
     * Column link in database is defined as TEXT, string generally changes to VARCHAR in SQL.
     * This line forces the column definition to change to TEXT
     */
    @Column(columnDefinition = "TEXT")
    private String link;

    //private String[] phNumbers;

    public AssistanceResource(){

    }
    public AssistanceResource(String title, String link, String[] phNumbers){
        this.title = title;
        this.link = link;
        //this.phNumbers = phNumbers;
    }

    //Getter and setter for the Id of the Assistance resource
    //depending on how the Question entity has been processed, the program picks the right AsstianceResource
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    //the title is the name of institution the User can turn to for help.
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    //the link to said institution (if it is available)
    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }
/*
    //Several phone numbers of the institution and it´s employees (if it is provided)
    public String[] getPhNumbers() { return phNumbers; }

    public void setPhNumbers(String[] phNumbers) { this.phNumbers = phNumbers; }
*/
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
