package uz.jl.repository;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.Question;
import uz.jl.mappers.QuestionMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.List;

public class QuestionRepository extends AbstractRepository<Question> implements
        GenericCrudRepository<Question, ObjectId> {

    protected QuestionRepository(Class<Question> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(Question entity) {
        return null;
    }

    @Override
    public void update(Question entity) {

    }


    @Override
    public void delete(ObjectId id) {

    }

    @Override
    public Question get(ObjectId id) {
        return null;
    }

    @Override
    public List<Question> getAll() {
        return null;
    }
}
