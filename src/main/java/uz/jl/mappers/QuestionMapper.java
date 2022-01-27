package uz.jl.mappers;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.Question;

public class QuestionMapper extends GenericMapper<Question, QuestionCreateDto, QuestionUpdateDto, ObjectId>{
    @Override
    public Question fromCreateDto(QuestionUpdateDto dto) {
        return null;
    }

    @Override
    public Question fromUpdateDto(ObjectId dto) {
        return null;
    }
}
