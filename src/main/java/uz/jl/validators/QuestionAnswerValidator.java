package uz.jl.validators;

import org.bson.types.ObjectId;
import uz.jl.dto.answer.QuestionAnswerCreateDto;
import uz.jl.dto.answer.QuestionAnswerUpdateDto;
import uz.jl.validators.base.GenericValidator;

/**
 * @author Doston Bokhodirov, Sat 6:12 PM. 1/29/2022
 */
public class QuestionAnswerValidator extends GenericValidator<QuestionAnswerCreateDto, QuestionAnswerUpdateDto, ObjectId> {

    @Override
    public void validKey(ObjectId id) {

    }

    @Override
    public void validOnCreate(QuestionAnswerCreateDto dto) {

    }

    @Override
    public void validOnUpdate(QuestionAnswerUpdateDto dto) {

    }
}
