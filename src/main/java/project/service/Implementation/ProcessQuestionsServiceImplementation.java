package project.service.Implementation;

import org.springframework.stereotype.Service;
import project.persistence.entities.Question;
import project.service.ProcessQuestionsService;

import java.util.List;
import java.util.Iterator;


@Service
public class ProcessQuestionsServiceImplementation implements ProcessQuestionsService {
    Question question = new Question();

    @Override
    public void saveAnswers(List<Question> answers) { //return repository.save(answers);

    }

    @Override
    public void processAnswers(List<Question> answers) {
        for (Iterator<Question> i: answers) {

            if(question.getId() == 3); // gerir ekki rass ennþá, þarf að setja eitt hvað inn.
        }

    }

    @Override
    public List<Question> getQuestions(int[] id) {
        return null;
    }
}
