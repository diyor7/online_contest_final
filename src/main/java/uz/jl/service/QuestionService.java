package uz.jl.service;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.Question;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.mappers.QuestionMapper;
import uz.jl.repository.QuestionRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.service.base.AbstractService;
import uz.jl.service.base.GenericCrudService;
import uz.jl.service.base.GenericService;
import uz.jl.validators.QuestionValidator;

import java.util.List;

public class QuestionService extends AbstractService<QuestionRepository, QuestionMapper, QuestionValidator> implements
        GenericCrudService<QuestionCreateDto, QuestionUpdateDto, ObjectId>,
        GenericService<QuestionDto, ObjectId> {

    public QuestionService(QuestionRepository repository, QuestionMapper mapper, QuestionValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(QuestionCreateDto dto) {
        try {
            validator.validOnCreate(dto);
            Question question = mapper.fromCreateDto(dto);
            question.setId(new ObjectId());
            ObjectId objectId = repository.create(question);
            return new ResponseEntity<>(new Data<>(objectId));
        } catch (IllegalArgumentException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }

    @Override
    public ResponseEntity<Data<Void>> update(QuestionUpdateDto dto) {
        try {
            validator.validOnUpdate(dto);
            Question question = mapper.fromUpdateDto(dto);
            repository.update(question);
            return new ResponseEntity<>(new Data<>(null));
        } catch (IllegalArgumentException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        try {
            repository.delete(id);
            return new ResponseEntity<>(new Data<>(null));
        } catch (IllegalArgumentException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }

    @Override
    public ResponseEntity<Data<QuestionDto>> get(ObjectId id) {
        try {
            Question question = repository.get(id);
            QuestionDto questionDto = mapper.toDto(question);
            return new ResponseEntity<>(new Data<>(questionDto));
        } catch (IllegalArgumentException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }

    @Override
    public ResponseEntity<Data<List<QuestionDto>>> getAll() {
        try {
            List<Question> questionList = repository.getAll();
            List<QuestionDto> questionDtoList = mapper.toDto(questionList);
            return new ResponseEntity<>(new Data<>(questionDtoList));
        } catch (IllegalArgumentException e) {
            throw new ApiRuntimeException(e.getMessage(), HttpStatus.HTTP_400);
        }
    }
}
