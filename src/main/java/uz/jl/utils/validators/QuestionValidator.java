package uz.jl.utils.validators;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.utils.validators.base.GenericValidator;

/**
 * @author Doston Bokhodirov, Thu 6:58 PM. 1/27/2022
 */
public class QuestionValidator extends GenericValidator<QuestionCreateDto, QuestionUpdateDto, ObjectId> {
    @Override
    public void validKey(ObjectId id) throws IllegalArgumentException {

    }

    @Override
    public void validOnCreate(QuestionCreateDto dto) throws IllegalArgumentException {

    }

    @Override
    public void validOnUpdate(QuestionUpdateDto dto) throws IllegalArgumentException {

    }
}
