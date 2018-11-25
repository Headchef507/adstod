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


    //The answer given will be saved in the entity Question.
    @Override
    public void saveAnswers(Question theQuestion, String theAnswer) { //return repository.save(answers);
        theQuestion.setAnswer(theAnswer);                             //First í you set the Answer in the Question for later use
        repository.saveAnswers(theQuestion);

/*
    }
    //After the User answers a question, the answer will processed here.
    //Depending on the id of the question, depends on how it will be processed.
    //Some questions have only two answer options and others several.
    //Depending on those, the User will recieve fewer questions.
    @Override
    public void processAnswers(List<Question> answers) {
        int i = 0; //telur upp hver object
        while(i < answers.size()){
            this.question = answers.get(i);
            if(question.getId() == 1 || question.getId() == 2); // gerir ekki rass ennþá, þarf að setja eitt hvað inn.
        }
*/
    }

    @Override
    //This is where get the next question to be used.
    public Question findOne(long id) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Question q = repository.findOne(id);
        System.out.println(q.getQuestionText());
        return repository.findOne(id);
        /*List<Question> questions = new List<Question>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Question> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Question question) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Question> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Question> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Question get(int index) {
                return null;
            }

            @Override
            public Question set(int index, Question element) {
                return null;
            }

            @Override
            public void add(int index, Question element) {

            }

            @Override
            public Question remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Question> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Question> listIterator(int index) {
                return null;
            }

            @Override
            public List<Question> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        long i = 1;
        repository.findOne(i);

        return questions;*/
    }
}
