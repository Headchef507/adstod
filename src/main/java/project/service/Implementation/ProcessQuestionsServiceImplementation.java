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
    private Question question = new Question();//bætti við þessu til að vinna í processAnswers
    private QuestionRepository repository = new QuestionRepository();


    @Override
    public Question findInitialQuestion() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        return this.repository.findQuestion((long) 1);
    }

    @Override
    public Question findNextQuestion(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (id == 4 || id == 9) {
            if(repository.getAnswers().get((int)id).getAnswer()==0)
                id += 2;
        }
        else {
            id += 1;
        }
        return this.repository.findQuestion(id);
    }

    //Goes to the previous question
    //currentQuestion is the current question
    //if it a jump question previously, it checks whether you answered that

    @Override
    public Question findPreviousQuestion(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        if(id==6 || id==10){
            if(repository.getAnswers().get((int)id).getAnswer()==0)
                id -= 2;
        }
        else {
            id -= 1;
        }
        return this.repository.findQuestion(id);
    }

    //The answer given will be saved in the entity Question and down in the Repo

    @Override
    public void saveAnswers(Question theQuestion, int theAnswer) { //return repository.save(answers);
        theQuestion.setAnswer(theAnswer);                             //First í you set the Answer in the Question for later use
        repository.saveAnswers((int)theQuestion.getId(),theQuestion);
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
            return repository.getAnswersSize();
    }

    public String getLanguage(){ return repository.getLanguage(); }

    public void setLanguage(String language){ repository.setLanguage(language); }
}
