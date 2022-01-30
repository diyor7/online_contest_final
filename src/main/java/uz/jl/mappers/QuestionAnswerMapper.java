package uz.jl.mappers;

import uz.jl.dto.answer.QuestionAnswerCreateDto;
import uz.jl.dto.answer.QuestionAnswerDto;
import uz.jl.dto.answer.QuestionAnswerUpdateDto;
import uz.jl.entity.QuestionAnswer;
import uz.jl.mappers.base.BaseGenericMapper;
import uz.jl.mappers.base.GenericMapper;

import java.util.List;

/**
 * @author Doston Bokhodirov, Sat 6:04 PM. 1/29/2022
 */
public class QuestionAnswerMapper extends GenericMapper<QuestionAnswer, QuestionAnswerDto, QuestionAnswerCreateDto, QuestionAnswerUpdateDto> {

    @Override
    public QuestionAnswer fromCreateDto(QuestionAnswerCreateDto dto) {
        return null;
    }

    @Override
    public QuestionAnswer fromUpdateDto(QuestionAnswerUpdateDto dto) {
        return null;
    }

    @Override
    public QuestionAnswerDto toDto(QuestionAnswer entity) {
        return null;
    }

    @Override
    public List<QuestionAnswerDto> toDto(List<QuestionAnswer> entityList) {
        return null;
    }

    @Override
    public QuestionAnswer fromDto(QuestionAnswerDto dto) {
        return null;
    }

    @Override
    public List<QuestionAnswer> fromDto(List<QuestionAnswerDto> dtoList) {
        return null;
    }
}
