package project.service;

import project.persistence.entities.Question;

import java.sql.SQLException;
import java.util.List;

public interface ProcessQuestionsService {

    //See the corresponding implementation for all information on this service
    //ProcessQuestionServiceImplementation

    void saveAnswers(Question theQuestion, int theAnswer);

    //int processAnswers(Question answers);

    Question findOne(long i) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    int findNextQuestion(Question answers);

    int findPreviousQuestion(Question currq);

    int getAnswersSize() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
}
