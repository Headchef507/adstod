package project.service;

import project.persistence.entities.Question;

import java.util.List;

public interface ProcessQuestionsService {

    //void saveAnswers(List<Question> answers, String theAnswer);

    //void processAnswers(List<Question> answers);

    List<Question> getQuestionsById(int i);
}
