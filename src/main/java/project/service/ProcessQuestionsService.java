package project.service;

import project.persistence.entities.Question;

import java.sql.SQLException;
import java.util.List;

public interface ProcessQuestionsService {

    //See the corresponding implementation for all information on this service
    //ProcessQuestionServiceImplementation

    void saveAnswers(Question theQuestion, int theAnswer);

    //int processAnswers(Question answers);

    Question findInitialQuestion() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    Question findNextQuestion(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    Question findPreviousQuestion(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    int getAnswersSize() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
}
