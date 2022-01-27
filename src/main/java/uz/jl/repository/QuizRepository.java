package uz.jl.repository;

import org.bson.types.ObjectId;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.entity.Quiz;
import uz.jl.mappers.quiz.QuizMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.List;

public class QuizRepository extends AbstractRepository<Quiz, QuizMapper>
        implements GenericCrudRepository<Quiz, QuizCreateDto, QuizUpdateDto, ObjectId> {

    protected QuizRepository(Class<Quiz> clazz, QuizMapper mapper) {
        super(clazz, mapper);
    }

    @Override
    public ObjectId create(QuizCreateDto dto) {
        return null;
    }

    @Override
    public void update(QuizUpdateDto dto) {

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