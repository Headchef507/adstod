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


    /*
    Vantar fleira!!
     */

}
