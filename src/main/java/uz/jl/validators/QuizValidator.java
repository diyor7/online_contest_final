package uz.jl.validators;

import org.bson.types.ObjectId;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.validators.base.GenericValidator;

/**
 * @author Doston Bokhodirov, Thu 7:00 PM. 1/27/2022
 */
public class QuizValidator extends GenericValidator<QuizCreateDto, QuizUpdateDto, ObjectId> {

    @Override
    public void validKey(ObjectId id) throws IllegalArgumentException {

    }

    @Override
    public void validOnCreate(QuizCreateDto dto) throws IllegalArgumentException {

    }

    @Override
    public void validOnUpdate(QuizUpdateDto dto) throws IllegalArgumentException {

    }
}
