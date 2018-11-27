package project.service.Implementation;

import org.springframework.stereotype.Service;
import project.persistence.entities.Question;
import project.persistence.repositories.QuestionRepository;
import project.service.ProcessQuestionsService;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;


@Service
public class ProcessQuestionsServiceImplementation implements ProcessQuestionsService {


    private QuestionRepository repository = QuestionRepository.getInstance();

    // Finds the initial question to start it all off
    @Override
    public Question findInitialQuestion() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        return this.repository.findQuestion((long) 1);
    }

    // Finds the next question after question number id
    // If it's a jump question it checks whether you answered that
    @Override
    public Question findNextQuestion(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (id == 4 || id == 9) {
            if(this.repository.getAnswers().get((int)id).getAnswer()==2)
                id += 2;
            else
                id += 1;
        }
        else
            id += 1;
        return this.repository.findQuestion(id);
    }

    // Finds the previous question to question number id
    // If it a jump question previously, it checks whether you answered that
    @Override
    public Question findPreviousQuestion(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        if(id==6 || id==11){
            if(this.repository.getAnswers().get((int)id-2).getAnswer()==2)
                id -= 2;
            else
                id -= 1;
        }
        else
            id -= 1;
        return this.repository.findQuestion(id);
    }

    // Receives the selected answer and stores it in the repository
    @Override
    public void saveAnswers(Question currentQuestion, int answer) {
        currentQuestion.setAnswer(answer);
        this.repository.saveAnswers((int)currentQuestion.getId(),currentQuestion);
    }

    //After the User answers a question, the answer will processed here.
    //Depending on the id of the question, depends on how it will be processed.
    //Some questions have only two answer options and others several.
    //Depending on those, the User will recieve fewer questions.
    //  @Override
    //Með nýju pælingunni þá er þetta essentially useless
    //   public int processAnswers(Question answers) { //breytti frá void yfir í Question svo við skilum til baka næstum spurningu
    // repository.saveAnswers(answers);
    //int i = 0; //telur upp hver object
    // while (i < answers.size()) {

    //     this.question = answers.get(i);

        /*    if (answers.getId() == 3 || question.getId() == 7) {
                if (answers.getAnswer() == 0)
                    return (int) (answers.getId() + 1); // gerir ekki rass ennþá, þarf að setja eitt hvað inn.
                else return (int) answers.getId() + 2;
            }
            return (int) answers.getId()+1;*/

    //}



    public int getAnswersSize() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return this.repository.getAnswersSize();
    }

    public String getLanguage(){ return this.repository.getLanguage(); }

    public void setLanguage(String language){ this.repository.setLanguage(language); }
}
