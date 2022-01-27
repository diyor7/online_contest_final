package uz.jl.mappers;

import uz.jl.dto.quiz.QuizCreateDto;
import uz.jl.dto.quiz.QuizDto;
import uz.jl.dto.quiz.QuizUpdateDto;
import uz.jl.entity.Quiz;
import uz.jl.mappers.base.BaseGenericMapper;
import uz.jl.mappers.base.GenericMapper;

import java.util.List;

public class QuizMapper extends GenericMapper<Quiz, QuizDto, QuizCreateDto, QuizUpdateDto> implements BaseGenericMapper {

    @Override
    public Quiz fromCreateDto(QuizCreateDto dto) {
        return null;
    }

    @Override
    public Quiz fromUpdateDto(QuizUpdateDto dto) {
        return null;
    }

    @Override
    public QuizDto toDto(Quiz entity) {
        return null;
    }

    @Override
    public List<QuizDto> toDto(List<Quiz> entityList) {
        return null;
    }

    @Override
    public Quiz fromDto(QuizDto dto) {
        return null;
    }

    @Override
    public List<Quiz> fromDto(List<QuizDto> dtoList) {
        return null;
    }
}
