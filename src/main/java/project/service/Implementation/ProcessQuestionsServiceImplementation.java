package project.service.Implementation;

import org.springframework.stereotype.Service;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.util.List;

@Service
public class ProcessQuestionsServiceImplementation implements ProcessQuestionsService {

    @Override
    public void saveAnswers(List<Question> answers) {

    }

    @Override
    public void processAnswers(List<Question> answers) {

    }

    @Override
    public List<Question> getQuestions(int[] id) {
        return null;
    }
}
