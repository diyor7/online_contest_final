package uz.jl.repository;

import org.bson.types.ObjectId;
import uz.jl.entity.Question;
import uz.jl.entity.QuestionAnswer;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.List;

/**
 * @author Doston Bokhodirov, Sat 6:02 PM. 1/29/2022
 */
public class QuestionAnswerRepository extends AbstractRepository<Question>
        implements GenericCrudRepository<QuestionAnswer, ObjectId> {

    public QuestionAnswerRepository(Class<Question> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(QuestionAnswer entity) {
        return null;
    }

    @Override
    public void update(QuestionAnswer entity) {

    }

    @Override
    public void delete(ObjectId id) {

    }

    @Override
    public QuestionAnswer get(ObjectId id) {
        return null;
    }

    @Override
    public List<QuestionAnswer> getAll() {
        return null;
    }
}
