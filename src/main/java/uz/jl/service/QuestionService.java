package uz.jl.service;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.repository.QuestionRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.service.base.AbstractService;
import uz.jl.service.base.GenericCrudService;
import uz.jl.service.base.GenericService;

import java.util.List;

public class QuestionService extends AbstractService<QuestionRepository> implements
        GenericCrudService<QuestionCreateDto, QuestionUpdateDto, ObjectId>,
        GenericService<QuestionDto, ObjectId> {


    public QuestionService(QuestionRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(QuestionCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> update(QuestionUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<QuestionDto>> get(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<QuestionDto>>> getAll() {
        return null;
    }
}
