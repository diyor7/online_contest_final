package uz.jl.service;

import org.bson.types.ObjectId;
import uz.jl.dto.answer.QuestionAnswerCreateDto;
import uz.jl.dto.answer.QuestionAnswerDto;
import uz.jl.dto.answer.QuestionAnswerUpdateDto;
import uz.jl.mappers.QuestionAnswerMapper;
import uz.jl.repository.QuestionAnswerRepository;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.service.base.AbstractService;
import uz.jl.service.base.GenericCrudService;
import uz.jl.service.base.GenericService;
import uz.jl.validators.QuestionAnswerValidator;

import java.util.List;

/**
 * @author Doston Bokhodirov, Sat 6:01 PM. 1/29/2022
 */
public class QuestionAnswerService extends AbstractService<QuestionAnswerRepository, QuestionAnswerMapper, QuestionAnswerValidator>
implements GenericCrudService<QuestionAnswerCreateDto, QuestionAnswerUpdateDto, ObjectId>, GenericService<QuestionAnswerDto, ObjectId> {

    public QuestionAnswerService(QuestionAnswerRepository repository, QuestionAnswerMapper mapper, QuestionAnswerValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<Data<ObjectId>> create(QuestionAnswerCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> update(QuestionAnswerUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<QuestionAnswerDto>> get(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<QuestionAnswerDto>>> getAll() {
        return null;
    }
}
