package project.service;

import project.persistence.entities.Question;

import java.util.List;

public interface ProcessQuestionsService {

    //See the corresponding implementation for all information on this service
    //ProcessQuestionServiceImplementation

    void saveAnswers(List<Question> answers, String theAnswer);

    //void processAnswers(List<Question> answers);

    Question findOne(long i);
}
