package uz.jl.repository;

import org.bson.types.ObjectId;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.entity.Quiz;
import uz.jl.mappers.QuizMapper;
import uz.jl.repository.base.AbstractRepository;
import uz.jl.repository.base.GenericCrudRepository;

import java.util.List;

public class QuizRepository extends AbstractRepository<Quiz>
        implements GenericCrudRepository<Quiz, ObjectId> {

    protected QuizRepository(Class<Quiz> clazz) {
        super(clazz);
    }

    @Override
    public ObjectId create(Quiz entity) {
        return null;
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