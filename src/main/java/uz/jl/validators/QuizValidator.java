package uz.jl.validators;

import org.bson.types.ObjectId;
import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.enums.Category;
import uz.jl.enums.HttpStatus;
import uz.jl.enums.Language;
import uz.jl.enums.Level;
import uz.jl.exception.ApiRuntimeException;
import uz.jl.validators.base.GenericValidator;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Doston Bokhodirov, Thu 7:00 PM. 1/27/2022
 */
public class QuizValidator extends GenericValidator<QuizCreateDto, QuizUpdateDto, ObjectId> {

    @Override
    public void validKey(ObjectId id) throws IllegalArgumentException {

    }

    @Override
    public void validOnCreate(QuizCreateDto dto) throws IllegalArgumentException {
        boolean language = false;
        boolean category = false;
        boolean level = false;

        for (Language value : Language.values()) {
            if (value.toString().equalsIgnoreCase(dto.getLanguage())) language = true;
        }
        if (!language) throw new ApiRuntimeException("LANGUAGE_NOT_PROVIDED", HttpStatus.HTTP_400);

        for (Category value : Category.values()) {
            if (value.toString().equalsIgnoreCase(dto.getCategory())) category = true;
        }
        if (!category) throw new ApiRuntimeException("CATEGORY_NOT_PROVIDED", HttpStatus.HTTP_400);

        for (Level value : Level.values()) {
            if (value.toString().equalsIgnoreCase(dto.getLevel())) level = true;
        }
        if (!level) throw new ApiRuntimeException("CATEGORY_NOT_PROVIDED", HttpStatus.HTTP_400);


    }

    @Override
    public void validOnUpdate(QuizUpdateDto dto) throws IllegalArgumentException {

    }
}
