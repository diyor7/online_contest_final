package uz.jl.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import org.bson.types.ObjectId;
import uz.jl.configs.ApplicationContextHolder;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.entity.Question;
import uz.jl.entity.Quiz;
import uz.jl.mappers.QuizMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;
import uz.jl.security.SecurityHolder;

import java.util.*;

import static uz.jl.security.SecurityHolder.user;

public class QuizRepository extends AbstractRepository<Question>
        implements GenericCrudRepository<Quiz, ObjectId> {

    public QuizRepository(Class<Question> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(Quiz entity) {
        Map<String, Object> mapMatch = new HashMap<>();
        mapMatch.put("category", entity.getCategory().name());
        mapMatch.put("language", entity.getLanguage().name());
        mapMatch.put("level", entity.getLevel().name());
        Map<String, Object> mapSimple = new HashMap<>();
        mapSimple.put("size", 20);
        BasicDBObject basicDBMatch = new BasicDBObject(mapMatch);
        BasicDBObject basicDBOSimple = new BasicDBObject(mapSimple);
        BasicDBObject queryMatch = new BasicDBObject("$match", basicDBMatch);
        BasicDBObject querySimple = new BasicDBObject("$sample", basicDBOSimple);
        ArrayList<Question> questions = new ArrayList<>();
        for (Question question : collection.aggregate(Arrays.asList(queryMatch, querySimple))) {
            questions.add(question);
        }
        entity.setQuestions(questions);

        if (Objects.nonNull(user.getCurrentQuiz())) {
            user.getCurrentQuiz().setClosed(true);
            user.getQuizzes().add(user.getCurrentQuiz());
        }
        user.setCurrentQuiz(entity);
        ApplicationContextHolder.getBean(UserRepository.class).update(user);
        return entity.getId();
    }

    @Override
    public void update(Quiz entity) {

    }

    @Override
    public void delete(ObjectId id) {

    }

    @Override
    public Quiz get(ObjectId id) {
        return null;
    }

    @Override
    public List<Quiz> getAll() {
        return null;
    }
}