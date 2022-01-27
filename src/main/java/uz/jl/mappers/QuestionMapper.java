package uz.jl.mappers;

import org.bson.types.ObjectId;
import uz.jl.dto.question.QuestionCreateDto;
import uz.jl.dto.question.QuestionUpdateDto;
import uz.jl.entity.Question;
import uz.jl.mappers.base.GenericMapper;

import java.util.List;

public class QuestionMapper extends GenericMapper<Question, QuestionCreateDto, QuestionUpdateDto, ObjectId> {

    @Override
    public Question fromCreateDto(QuestionUpdateDto dto) {
        return null;
    }

    @Override
    public Question fromUpdateDto(ObjectId dto) {
        return null;
    }

    @Override
    public QuestionCreateDto toDto(Question entity) {
        return null;
    }

    @Override
    public List<QuestionCreateDto> toDto(List<Question> entityList) {
        return null;
    }

    @Override
    public Question fromDto(QuestionCreateDto dto) {
        return null;
    }

    @Override
    public List<Question> fromDto(List<QuestionCreateDto> dtoList) {
        return null;
    }
}
