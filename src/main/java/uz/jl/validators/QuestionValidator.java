package uz.jl.validators;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.enums.HttpStatus;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.validators.base.GenericValidator;

import java.util.Objects;

/**
 * @author Doston Bokhodirov, Thu 6:58 PM. 1/27/2022
 */
public class QuestionValidator extends GenericValidator<QuestionCreateDto, QuestionUpdateDto, ObjectId> {
    @Override
    public void validKey(ObjectId id) throws IllegalArgumentException {

    }

    @Override
    public void validOnCreate(QuestionCreateDto dto) throws IllegalArgumentException {
        if (Objects.isNull(dto.getTitle())
                || Objects.isNull(dto.getLanguage())
                || Objects.isNull(dto.getAnswers())
                || Objects.isNull(dto.getCategory())
                || Objects.isNull(dto.getLevel())
                || Objects.isNull(dto.getMark())) {
            throw new ApiRuntimeException("BAD_REQUEST", HttpStatus.HTTP_400);
        }
    }

    @Override
    public void validOnUpdate(QuestionUpdateDto dto) throws IllegalArgumentException {
        if (Objects.isNull(dto.getId())) {
            throw new ApiRuntimeException("BAD_REQUEST", HttpStatus.HTTP_400);
        }

    }
}
