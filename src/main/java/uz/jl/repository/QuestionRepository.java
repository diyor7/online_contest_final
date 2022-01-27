package uz.jl.repository;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.Question;
import uz.jl.mappers.QuestionMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.List;

public class QuestionRepository extends AbstractRepository<Question, QuestionMapper> implements
        GenericCrudRepository<Question, QuestionCreateDto, QuestionUpdateDto, ObjectId> {

    protected QuestionRepository(Class<Question> clazz, QuestionMapper mapper) {
        super(clazz, mapper);
    }

    @Override
    public ObjectId create(QuestionCreateDto dto) {
        return null;
    }

    @Override
    public void update(QuestionUpdateDto dto) {

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
