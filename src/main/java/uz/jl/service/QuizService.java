package uz.jl.service;

import org.bson.types.ObjectId;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.entity.Quiz;
import uz.jl.mappers.QuizMapper;
import uz.jl.repository.QuizRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.service.base.AbstractService;
import uz.jl.service.base.GenericCrudService;
import uz.jl.service.base.GenericService;
import uz.jl.validators.QuizValidator;

import java.util.List;

public class QuizService extends AbstractService<QuizRepository, QuizMapper, QuizValidator> implements
        GenericCrudService<QuizCreateDto, QuizUpdateDto, ObjectId>,
        GenericService<QuizDto, ObjectId> {

    public QuizService(QuizRepository repository, QuizMapper mapper, QuizValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(QuizCreateDto dto) {
        validator.validOnCreate(dto);
        Quiz quiz = mapper.fromCreateDto(dto);
        repository.create(quiz);
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> update(QuizUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<QuizDto>> get(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<QuizDto>>> getAll() {
        return null;
    }
}

