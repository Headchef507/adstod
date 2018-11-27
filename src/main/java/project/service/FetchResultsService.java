package project.service;

import project.persistence.entities.AssistanceResource;
import project.persistence.entities.Question;
import project.persistence.entities.Result;

import java.sql.SQLException;
import java.util.List;

public interface FetchResultsService {

    //Information in corresponding implementation (FetchResultsServiceImplementation)

    List<AssistanceResource> getResults() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

}
